/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.ejb;

import co.edu.uniandes.csw.recipes.entities.RecipeEntity;
import co.edu.uniandes.csw.recipes.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.recipes.persistence.RecipePersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author CesarF
 */
@Stateless
public class RecipeLogic {
    @Inject
    private RecipePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    public RecipeEntity getRecipe(Long id) {
        return persistence.find(id);
    }

    //TODO crear el método createRecipe
    public RecipeEntity createRecipe(RecipeEntity recipeEntity) throws BusinessLogicException{
        if(recipeEntity.getName()==null || recipeEntity.getName().length()>30)
            throw new BusinessLogicException("El nombre no es valido");
        
        if(recipeEntity.getDescription()==null || recipeEntity.getDescription().length()>150)
            throw new BusinessLogicException("La descripcion no es valida");
        
        if(getRecipe(recipeEntity.getId())!=null && getRecipe(recipeEntity.getId()).getName().equals(recipeEntity.getName()))
            throw new BusinessLogicException("La recipe ya existe");
        
        if(recipeEntity.getIngredients().size()==0 )
            throw new BusinessLogicException("No hay ingredientes");
        
        persistence.create(recipeEntity);
        return recipeEntity;
    }

}
