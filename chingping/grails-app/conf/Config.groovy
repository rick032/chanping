import org.apache.log4j.DailyRollingFileAppender
import org.apache.log4j.PatternLayout

// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
	all:           '*/*',
	atom:          'application/atom+xml',
	css:           'text/css',
	csv:           'text/csv',
	form:          'application/x-www-form-urlencoded',
	html:          [
		'text/html',
		'application/xhtml+xml'
	],
	js:            'text/javascript',
	json:          [
		'application/json',
		'text/json'
	],
	multipartForm: 'multipart/form-data',
	rss:           'application/rss+xml',
	text:          'text/plain',
	xml:           [
		'text/xml',
		'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = [
	'/images/*',
	'/css/*',
	'/js/*',
	'/plugins/*'
]

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false
def log4jConsoleLogLevel = org.apache.log4j.Level.INFO
def log4jAppFileLogLevel = org.apache.log4j.Level.INFO
environments {
	development {
		grails.logging.jul.usebridge = true
		log4jConsoleLogLevel = org.apache.log4j.Level.DEBUG
		log4jAppFileLogLevel = org.apache.log4j.Level.DEBUG
	}
	production {
		grails.logging.jul.usebridge = false
		// TODO: grails.serverURL = "http://www.changeme.com"
	}
}

// log4j configuration
log4j = {
	println "Log4j consoleLevel: ${log4jConsoleLogLevel} appFile Level: ${log4jAppFileLogLevel}"

	def logLayoutPattern = new PatternLayout("%d [%t] %X{IP}-%X{empNo}-%X{loginId} %X{URL}  %-5p %c %x - %m%n")
	appenders {
		console name: "stdout",
		threshold: log4jConsoleLogLevel,
		layout: logLayoutPattern

		appender new DailyRollingFileAppender( name: "appFile",
		threshold: log4jConsoleLogLevel,
		file: "logs/echanping.log",
		datePattern: "'.'yyyy-MM-dd",
		layout: logLayoutPattern)
	}
	
	root {
		debug 'stdout'
		debug 'appFile'
	}

	error   'org.codehaus.groovy.grails.web.pages',           // GSP
			'org.codehaus.groovy.grails.web.sitemesh',       // layouts
			'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
			'org.codehaus.groovy.grails.web.mapping',        // URL mapping
			'org.codehaus.groovy.grails.commons',            // core / classloading
			'org.codehaus.groovy.grails.plugins',            // plugins
			'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
			'org.codehaus.groovy.grails.web.servlet',        // controllers
			'org.codehaus.groovy.grails.web.binding',
			'org.springframework',
			'org.hibernate',
			'net.sf.ehcache.hibernate',
			'org.grails.plugin',
			'org.apache',
			'grails.app.taglib',
			'grails.app.resourceMappers'

	debug   'tw.com.chanping',
		    'grails.app.controller'
}
def baseUrl = "http://localhost:8080/chingping"
oauth {
	providers {
		google {
			api = org.scribe.builder.api.GoogleApi
			key = '324208703999-3rbn3lool01t5h1ta5douudqcgd7r9m4.apps.googleusercontent.com'
			secret = 'IUQZsztfdJa_ey0dU2ca8R_Q'
			scope = 'https://www.googleapis.com/auth/calendar'
			successUri = "${baseUrl}/main/google"
			failureUri = '/calendar/fail'
			callback = "${baseUrl}/oauth/google/callback"
		}
	}

	debug = true
	connectTimeout = 5000
	receiveTimeout = 5000
}
grails.google.api.url = "https://www.googleapis.com/oauth2/v1/userinfo"
