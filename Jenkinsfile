#!/usr/bin/env groovy

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
        	def mvnHome = tool name: 'Maven', type: 'maven'		
        	sh "{$mvnHome}/bin/mvn clean install"
        }
    }
}

// Deletes all files and folders from the current dir
void cleanCurrentDir() {
    sh "find . -mindepth 1 -delete"
}

