#!/usr/bin/env groovy

pipeline {
    agent none
    
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
	        	//mvnHome = tool name: 'Maven3', type: 'maven'		
	        	//sh "{$mvnHome}/bin/mvn clean install"
	        	sh "/opt/maven/apache-maven-3.6.2/bin/mvn clean install"
	        }
        }
    }
}

// Deletes all files and folders from the current dir
void cleanCurrentDir() {
    sh "find . -mindepth 1 -delete"
}

