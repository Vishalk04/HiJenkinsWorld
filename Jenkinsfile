node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

    stage('Build image') {
        sh 'mvn clean install'
        
    
        /* This builds the actual image; synonymous to
         * docker build on the command line */

        app = docker.build("kartikjalgaonkar/hi-world")
    }

    stage('Push image') {
        /* Finally, we'll push the image with two tags:
         * First, the incremental build number from Jenkins
         * Second, the 'latest' tag.
         * Pushing multiple tags is cheap, as all the layers are reused. */
        docker.withRegistry('https://registry.hub.docker.com', 'docker_credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
    
    stage('kubectl deploy'){
        sh 'minikube start'
        sh 'kubectl run my-app --image=kartikjalgaonkar/hi-world --port=8082'
        sleep 30s
        sh 'kubectl get pods'
        sleep 30s
        sh 'kubectl expose deployment my-app --type=NodePort --port=8083 --target-port=8082'
        sh 'kubectl get svc'
    }
    
}

