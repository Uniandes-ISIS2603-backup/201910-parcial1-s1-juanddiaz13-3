/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.dtos;

import co.edu.uniandes.csw.recipes.entities.IngredientEntity;

/**
 *
 * @author estudiante
 */
public class IngredientDTO {
    
    private Long id;
    private String name;
    private Long calories;
    public IngredientDTO(){
        
    }
    
    public IngredientDTO(IngredientEntity ingredient) {
    this.id = ingredient.getId();
    this.name = ingredient.getName();
    this.calories = ingredient.getCalories();
}
}
