package com.nursery.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.exception.PlantException;
import com.nursery.repository.PlantDao;
import com.nursery.model.Plant;

@Service
public class PlantServicesImpl implements PlantServices {

	@Autowired
	private PlantDao dao;

	
	
	
	
//ADD PLANT Implementation-------------------------------------------------------------------------
	
	@Override
	public Plant addPlant(Plant plant) throws PlantException {
	
        Plant addPlant=dao.save(plant);

        if(addPlant!=null)
        {
        	return addPlant;
        }
         
        
        else {
        throw new PlantException("Plant details are empty........");
		}
}




//UPDATE PLANT-------------------------------------------------------------------------------------------------------------------

    @Override
	public Plant updatePlant(Plant plant) throws PlantException {
		
		Optional<Plant>opt=dao.findById(plant.getPlantId());
		
		if(opt.isPresent())
		{
			Plant pl=dao.save(plant);
			return pl;
		}
	
	
	else {
        throw new PlantException("Plant with given id is not presesnt........");

	}
		
		
	}

	
//DELETE PLANT-----------------------------------------------------------------------------------------------------
	
	@Override
	public Plant deletePlant(Plant plant) throws PlantException {

   Optional<Plant>opt=dao.findById(plant.getPlantId());
		
		if(opt.isPresent())
		{
			
				dao.delete(opt.get());
				return plant;
			
			 
		}
	
	
	else {
		
        throw new PlantException("This Plant is not present ........");

	}
		
}




	
//Get List of all Plants--------------------------------------------------------------------------------------------------------------------------------	
	
	

	@Override
	public List<Plant> getAllPlants() throws PlantException {
		
		  List<Plant> plants=dao.findAll();

	        if(plants.size()>0)
	        {
	        	return plants;
	        }
	         
	        
	        else 
	        {
	        	
	        throw new PlantException("Plant details List is empty........");
	        
			}
	
	}
	
	
	
//Get Plant By Id-----------------------------------------------------------------------------------------------------------------------------------		

    @Override
	public Plant getPlantById(Integer id) throws PlantException {
		
		 Optional<Plant>opt=dao.findById(id);
			
			if(opt.isPresent())
			{
				
				Plant plant=opt.get();
				
				return plant;
			}
		
		
		else {
			
	        throw new PlantException("This Plant with given id is not present ........");

		}
	}
	
    
 //Get Plant By Common Name(Check this method once again..............)-------------------------------------------------------------------------------------------------------------------------------------------------------	
	
    
    
    @Override
    public List<Plant> getPlantBycommonName(String commonName) throws PlantException {
    	
    	List<Plant> p=dao.getPlantBycommonName(commonName);
   	 
   	 System.out.println(p);
   
   	if(p.size()>0)
   	{
   	 System.out.println(p);
   		return p;
   	}
   	else {
           throw new PlantException("This Plant with given Common name is not present ........");
   
   	}
   	
    	
    }




//------------------------------------------------------------------------------------------------------------------


@Override
public List<Plant> getplantByTypeOfPlant(String typeOfPlant) throws PlantException {

	List<Plant>paList=dao.getPlantBytypeOfPlant(typeOfPlant);
	if(paList.size()>0)
	{
		return paList;
	}
	else {
		throw new PlantException("List of given type of plant is not present");
	}

}





	
	
	
}