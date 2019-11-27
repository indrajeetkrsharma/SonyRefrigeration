pipeline {
    agent any

    stages {
        stage ('Checkout ') {

            steps {
                   sh 'mvn clean compile'
            }
        }

        stage ('Testing Stage') {

            steps {
                    sh 'mvn test'
            }
        }

        stage ('Deployment Stage') {
            steps {
                    sh 'mvn deploy'
            }
        }
    }
}

