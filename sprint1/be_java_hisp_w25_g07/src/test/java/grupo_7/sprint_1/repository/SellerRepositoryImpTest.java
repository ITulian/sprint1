package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.entity.Seller;
import org.junit.Assert;
import org.testng.annotations.Test;
import unit.test.api.ObjectInit;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
 
public class SellerRepositoryImpTest {

 
    @Test
    public void testUpdateSeller() { 
        // Initialize the object to be tested
        SellerRepositoryImp sellerRepositoryImp = ObjectInit.random(SellerRepositoryImp.class);
        // Initialize params of the method
        
        Seller seller = ObjectInit.random(Seller.class);;
        sellerRepositoryImp.updateSeller(seller);

        // Write the Assert code
        Assert.assertTrue(true);
        //Assert.assertEquals(expected, actual);
    }

 
    @Test
    public void testGetAllSellers() { 
        // Initialize the object to be tested
        SellerRepositoryImp sellerRepositoryImp = ObjectInit.random(SellerRepositoryImp.class);
        List<Seller> invokeResult = sellerRepositoryImp.getAllSellers();

        // Write the Assert code
        //Assert.assertEquals(expected, invokeResult);
    }

 
    @Test
    public void testFindById() { 
        // Initialize the object to be tested
        SellerRepositoryImp sellerRepositoryImp = ObjectInit.random(SellerRepositoryImp.class);
        // Initialize params of the method
        
        Integer userId = ObjectInit.random(Integer.class);;
        Optional<Seller> invokeResult = sellerRepositoryImp.findById(userId);

        // Write the Assert code
        //Assert.assertEquals(expected, invokeResult);
    }

 
    @Test
    public void testCantidadDeSeguidores() { 
        // Initialize the object to be tested
        SellerRepositoryImp sellerRepositoryImp = ObjectInit.random(SellerRepositoryImp.class);
        // Initialize params of the method
        
        int userId = ObjectInit.random(int.class);;
        Int invokeResult = sellerRepositoryImp.cantidadDeSeguidores(userId);

        // Write the Assert code
        //Assert.assertEquals(expected, invokeResult);
    }

 
    @Test
    public void testLoadSellers() { 
        // Initialize the object to be tested
        SellerRepositoryImp sellerRepositoryImp = ObjectInit.random(SellerRepositoryImp.class);
        try {
            Method sellerRepositoryImploadSellers = sellerRepositoryImp.getClass().getMethod("loadSellers");
            sellerRepositoryImploadSellers.setAccessible(true);
            sellerRepositoryImploadSellers.invoke();
         } catch (Exception e) {
            e.printStackTrace();
        };

        // Write the Assert code
        Assert.assertTrue(true);
    }
}