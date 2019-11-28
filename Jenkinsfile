pipeline {
    agent any
    
    options {
        skipDefaultCheckout()
    }
    
    stages {
        stage ('CheckOut') {

            steps {
            		checkout scm
            	  }
        	}
        
        stage ('Build') {
        	steps {
        		def mvn = tool (name: 'Maven', type: 'maven') + '/bin/mvn'
        		sh 'mvn clean build'
        	}
        }
    }
}

