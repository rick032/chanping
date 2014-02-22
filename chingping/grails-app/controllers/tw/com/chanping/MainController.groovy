package tw.com.chanping
import grails.converters.JSON
import groovy.sql.Sql
import org.scribe.model.Token

import tw.com.chanping.GCalendar;
import uk.co.desirableobjects.oauth.scribe.OauthService
class MainController {
	GCalendar gCal
	OauthService oauthService

	def index() {
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
	def dataSource
	def getCtm(){
		
		def res = [:]
		def sql = new Sql(dataSource)
		//sql.eachRow("SELECT * from Goods c where c.ctmno='A-001'") { c ->
		def rows = sql.rows("SELECT * from Ctm c where c.ctmno='A-001'")
		
		//sql.eachRow("SELECT * from Ctm c where c.ctmno='A-001'") { c ->
		rows.each { c ->			
			res['ctmno'] = c.ctmno
			res['ctmname'] = c.ctmname
			println c.ctmname
			res['tel1'] = c.tel1
		}
		sql.close()
		
		log.debug "end~~~~~~~~~"
				
		render res as JSON
	}
}