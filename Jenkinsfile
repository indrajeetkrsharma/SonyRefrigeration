pipeline {
    agent any
    
    tools {
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
        		//def mvn = tool (name: 'Maven', type: 'maven') + '/bin/mvn'
        		echo "PATH = ${PATH}"
				echo "M2_HOME = ${M2_HOME}"
        		sh 'mvn clean install'
        	}
        }
    }
}

