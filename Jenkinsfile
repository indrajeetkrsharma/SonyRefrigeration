pipeline {
    agent any

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

