
#Se placer dans le dossier CONTENANT le dossier "exojavarmi" et ce fichier readme.



#Compilation :
javac exojavarmi/hotel/*.java

#Generation des souches :
rmic exojavarmi.hotel.ChaineHotels

#Creation d'un fichier texte "security.policy" contenant la politique de securite retenue
# (ici on autorise tout... dangereux !)




#Utilisation de l'application :

#On suppose que le dossier "exojavarmi" est dans un dossier "SR"

#On suppose que le serveur tourne sur la machine 134.192.30.6
# et le registre utilise le port par defaut 1099 (le registre rmi tourne aussi sur la machine 134.192.30.6)


#Sur la machine "serveur" :

#Lancement du registre rmi :
rmiregistry

#Se placer dans le dossier "SR"

#Lancement du programme serveur :
java -cp . -Djava.security.policy=/filer/eleves/e00000/SR/exojavarmi/hotel/security.policy -Djava.rmi.server.codebase=file:/filer/eleves/e00000/SR/  exojavarmi.hotel.ChaineHotelsServeurRMI



#Sur la machine "client" :

#Lancement du programme client :
java -cp . -Djava.security.policy=/filer/eleves/e00000/SR/exojavarmi/hotel/security.policy -Djava.rmi.server.codebase=file:/filer/eleves/e00000/SR/  exojavarmi.hotel.ChaineHotelsClientRMI 134.192.30.6 1099

