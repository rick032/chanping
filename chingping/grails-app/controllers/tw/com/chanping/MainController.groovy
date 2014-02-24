package tw.com.chanping
import grails.converters.JSON
import groovy.sql.Sql

import java.text.SimpleDateFormat

import org.scribe.model.Token

import uk.co.desirableobjects.oauth.scribe.OauthService
class MainController {
	GCalendar gCal
	OauthService oauthService
	def dataSource
	def index() {
		def responList = []
		/*
		 def sql = new Sql(dataSource)
		 //sql.eachRow("SELECT * from Goods c where c.ctmno='A-001'") { c ->
		 def rows = sql.rows("SELECT * from Opitem o ")
		 int i = 1
		 rows.each { c ->
		 def res = [:]
		 if(i > 5 ) return
		 res['sn'] = i++
		 res['tradeno'] = c.tradeno
		 res['tradedate'] = c.tradedate
		 res['goodno'] = c.goodno
		 responList.add(res)
		 }
		 sql.close()*/
		return [opitems:responList]
	}

	def google() {
		Token googleAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('google')]
		//def googleResource = oauthService.getGoogleResource(googleAccessToken, grailsApplication.config.grails.google.api.url)
		def googleResource = oauthService.getGoogleResource(googleAccessToken, "https://www.googleapis.com/calendar/v3/calendars/james.kcir%40gmail.com/events?timeMax=2014-03-01T00%3A00%3A00.01Z&timeMin=2014-02-01T00%3A00%3A00.01Z")

		def googleResponse = JSON.parse(googleResource?.getBody())
		log.info "googleResponse" + googleResponse.items
		//		log.info "googleAccessToken = ${googleAccessToken}"
		//		log.info "googleResponse = ${googleResponse}"
		//		log.info "accesstoken = ${googleAccessToken.token}"
		//		log.info "id = ${googleResponse.id}"
		//		log.info "name = ${googleResponse.name}"

		render googleResponse.items
	}
	def syncToGoogle(){
		//def dbfreader = new DBFReader(grailsApplication.config.DBF.url+"goods"+".dbf")


	}
	def dateFormatForDBF = new SimpleDateFormat("yyyy,MM,dd")
	def getEvents(){
		def start = params.start
		def end = params.end
		if(!end){
			//get last day of month
			Calendar calendar = Calendar.getInstance()
			calendar.setTime(dateFormatForDBF.parse(start))
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
			end = dateFormatForDBF.format(calendar.getTime())
			println end
		}
		def sql = new Sql(dataSource)
		//sql.eachRow("SELECT * from Goods c where c.ctmno='A-001'") { c ->
		def sqlQuery = "select DISTINCT c.CTMNAME,o.TRADENO,o.TRADEDATE from opitem o LEFT JOIN ctm c on o.ctmno=c.ctmno "+
				"where TRADEDATE between datetime("+start+") and datetime("+end+")"
		println sqlQuery
		def rows = sql.rows(sqlQuery)

		//sql.eachRow("SELECT * from Ctm c where c.ctmno='A-001'") { c ->
		def resList = []
		rows.each { c ->
			def res = [:]
			res['id'] = c.TRADENO?.trim()
			res['title'] = c.ctmname?.trim()
			res['start'] =c.TRADEDATE
			resList.add res
		}
		sql.close()

		log.debug "end~~~~~~~~~"

		render resList as JSON
	}

	def getEvent() {
		def tradeno = params.tradeno
		def responList = []
		if(tradeno){
			int i = 1
			def sql = new Sql(dataSource)
			def rows = sql.rows("select c.CTMNAME,c.TEL1,c.TEL2,o.TRADENO,o.CTMNO,o.TRADEDATE,o.GOODNO,GOODNAME,TRADEQTY from opitem o LEFT JOIN ctm c on o.ctmno=c.ctmno LEFT JOIN GOODS g ON o.goodno=g.goodno "+
					"where o.TRADENO='"+ tradeno +"'")
			rows.each { c ->
				def res = [:]
				res['sn'] = i++
				res['TRADEQTY'] = c.TRADEQTY
				res['GOODNO'] = c.GOODNO?.trim()
				res['GOODNAME'] = c.GOODNAME?.trim()
				responList.add res
			}
			sql.close()
		}
		render responList as JSON
	}
}