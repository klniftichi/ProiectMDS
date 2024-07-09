package test;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import project.Address;
import service.AddressService;
import service.DatabaseQueryExecutorService;

public class AddressServiceTest {

    @Mock
    private DatabaseQueryExecutorService databaseQueryExecutorService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateAddress() {
        // Arrange
        int clientId = 1;
        String newCity = "New City";
        String newStreet = "New Street";

        Address updatedAddress = new Address(newCity, "Country", newStreet); // Assuming 'Country' is unchanged

        // Mock
        when(databaseQueryExecutorService.updateAddressQuery(clientId, newCity, newStreet)).thenReturn(updatedAddress);

        // Act
        Address result = AddressService.updateAddres(clientId, newCity, newStreet);

        // Assert
        assertEquals(newCity, result.getCity());
        assertEquals(newStreet, result.getStreet());
        assertEquals("Country", result.getCountry());

        // Verify that the mock was called with the correct parameters
        verify(databaseQueryExecutorService).updateAddressQuery(clientId, newCity, newStreet);
    }
}