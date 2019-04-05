#Exclusion mutuelle sur un anneau a jeton

#Version javarmi

#Se placer dans le dossier contenant le dossier "anneauexclurmi"


#compilation

javac anneauexclurmi/*.java


#generation du talon (Stub)

rmic anneauexclurmi.SiteImpl


#lancement du serveur central

java -cp . anneauexclurmi.ServeurCentral 5000 100


#lancement du registre rmi

rmiregisry


#lancement de 3 sites

java -cp . -Djava.security.policy=/home/nicolas/Bureau/anneauexclurmi/security.policy -Djava.rmi.server.codebase=file:/.  anneauexclurmi.ProgrammeSite 127.0.0.1 5000 1 127.0.0.1 1099 true 2

java -cp . -Djava.security.policy=/home/nicolas/Bureau/anneauexclurmi/security.policy -Djava.rmi.server.codebase=file:/.  anneauexclurmi.ProgrammeSite 127.0.0.1 5000 2 127.0.0.1 1099 false 3

java -cp . -Djava.security.policy=/home/nicolas/Bureau/anneauexclurmi/security.policy -Djava.rmi.server.codebase=file:/.  anneauexclurmi.ProgrammeSite 127.0.0.1 5000 3 127.0.0.1 1099 false 1


