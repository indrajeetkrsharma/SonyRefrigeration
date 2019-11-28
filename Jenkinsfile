pipeline {
    agent any
    
    tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "Maven"
   }
    
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
        		//cleanCurrentDir()
                    sh 'mvn clean install'
        	}
        }
    }
}

// Deletes all files and folders from the current dir
void cleanCurrentDir() {
    sh "find . -mindepth 1 -delete"
}

