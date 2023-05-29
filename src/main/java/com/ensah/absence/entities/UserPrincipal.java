package com.ensah.absence.entities;



public class UserPrincipal  {

	//Le compte utilisateur (classe persistante à gérer par ORM)
	private Compte user;


	
	//TODO : Cette méthode définie le role de l'utilisateur
	// si vous changer la conception de vos classe User/Role il faut la mettre à jour
	// Les Role doivent être créer sous forme d'une collection de type GrantedAuthority
	// Dans notre conception l'utilisateur a un et un seul role, ainsi il suffit de créer 
	// un objet de type GrantedAuthority avec le role définit par user.getRole().getRoleName()
	// donc enfin la collection des roles de l'utilisateur contient un seul role sous forme 
	// de GrantedAuthority


	
	//TODO : les méthodes suivantes à adapter si vous changer la conception des classes
	//Sinon vous pouvez les laisser telles quelles 

}