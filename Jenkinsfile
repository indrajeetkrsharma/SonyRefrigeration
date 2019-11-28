pipeline {
    agent any
    
    options {
        skipDefaultCheckout()
    }
    
    stages {
        stage ('CheckOut') {

            steps {
           			tool name: 'Maven', type: 'maven'
            		checkout scm
            	  }
        	}
        
        stage ('Build') {
        
        	steps {
        		sh 'mvn clean install'
        	}
        }
    }
}

// Deletes all files and folders from the current dir
void cleanCurrentDir() {
    sh "find . -mindepth 1 -delete"
}

