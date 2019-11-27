pipeline {
    agent any
    
	options {
        skipDefaultCheckout(true)
        //buildDiscarder(logRotator(artifactDaysToKeepStr: '1', artifactNumToKeepStr: '1', daysToKeepStr: '5', numToKeepStr: '20'))
    }
    
    stages {
        stage ('CheckOut') {

            steps {
            		cleanCurrentDir()
                	checkout scm
                   //checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GitHub', url: 'https://github.com/indrajeetkrsharma/SonyRefrigeration.git']]])
            }
        }
    }
}

