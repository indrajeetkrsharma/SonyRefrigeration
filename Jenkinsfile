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
        		cleanCurrentDir()
        		echo "PATH = ${PATH}"
				echo "M2_HOME = ${M2_HOME}"
        		sh "mvn clean install"
        	}
        }
    }
}

// Deletes all files and folders from the current dir
void cleanCurrentDir() {
    sh "find . -mindepth 1 -delete"
}

