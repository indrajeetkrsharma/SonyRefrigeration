pipeline {
    agent any
    
    options {
        skipDefaultCheckout()
    }
    
    stages {
        stage ('CheckOut') {

            steps {
            		checkout scm
            		//cleanCurrentDir()
            		//skipDefaultCheckout()
                    //checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GitHub', url: 'https://github.com/indrajeetkrsharma/SonyRefrigeration.git']]])
            }
        }
        
        stage ('Build') {
        	steps {
        		def mvn = tool (name: 'maven3', type: 'maven') + '/bin/mvn'
        		sh 'mvn clean build'
        	}
        }
    }
}

