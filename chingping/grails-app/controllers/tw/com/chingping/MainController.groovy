package tw.com.chingping
import grails.converters.JSON
import uk.co.desirableobjects.oauth.scribe.OauthService
import org.scribe.model.Token
class MainController {

	OauthService oauthService
	
	def index() {
	}

	def google() {
		Token googleAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('google')]
		def googleResource = oauthService.getGoogleResource(googleAccessToken, grailsApplication.config.grails.google.api.url)
		def googleResponse = JSON.parse(googleResource?.getBody())

		log.info "googleAccessToken = ${googleAccessToken}"
		log.info "googleResponse = ${googleResponse}"
		log.info "accesstoken = ${googleAccessToken.token}"
		log.info "id = ${googleResponse.id}"
		log.info "name = ${googleResponse.name}"

		render params
	}
}