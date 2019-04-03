#attention a la variable d'environnement CLASSPATH

CLASSPATH=.:$CLASSPATH
export CLASSPATH

#remarque : cela peut etre permanent en modifiant votre fichier .profile (ou .bashrc) a la racine de votre compte



#se placer dans le dossier CONTENANT le dossier "exemples"


#compilation

javac exemples/javarmi/hello/*.java

rmic exemples.javarmi.hello.HelloImpl



#execution (utiliser 3 terminaux)

rmiregistry

java -cp . -Djava.security.policy=/cheminAindiquer/exemples/javarmi/hello/security.policy -Djava.rmi.server.codebase=file:/cheminAindiquer/ exemples.javarmi.hello.HelloServer


java -cp . -Djava.security.policy=/cheminAindiquer/exemples/javarmi/hello/security.policy -Djava.rmi.server.codebase=file:/cheminAindiquer/ exemples.javarmi.hello.HelloClient


