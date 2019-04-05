#attention a la variable d'environnement CLASSPATH

CLASSPATH=.:$CLASSPATH
export CLASSPATH


#remarque : cela peut etre permanent en modifiant votre fichier .profile (ou .bashrc) a la racine de votre compte



#se placer dans le dossier CONTENANT le dossier "exemples"


#compilation

javac exemples/javarmi/appelsretour/*.java

rmic exemples.javarmi.appelsretour.Server

rmic exemples.javarmi.appelsretour.Callback


#execution (utiliser 3 terminaux)

rmiregistry

java -cp . -Djava.security.policy=/cheminAindiquer/exemples/javarmi/appelsretour/security.policy -Djava.rmi.server.codebase=file:/cheminAindiquer/ exemples.javarmi.appelsretour.Server

java -cp . -Djava.security.policy=/cheminAindiquer/exemples/javarmi/appelsretour/security.policy -Djava.rmi.server.codebase=file:/cheminAindiquer/ exemples.javarmi.appelsretour.Client

