package test; 

import java.io.Reader;
import java.io.IOException;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DbOperationFactory { 
    
    // The configuration file
    private static final String DEFAULT_CONFIG_FILE = "resources/SQLMapConfig.xml" ;
    
    // Map client object        
    private SqlMapClient smc = null ;    
    
    private boolean isUseCache = false;
    
    public DbOperationFactory(String file) throws IOException { 
        try {
            if(file == null) 
                file = DEFAULT_CONFIG_FILE ;                
            Reader reader = Resources.getResourceAsReader(file);
            smc = SqlMapClientBuilder.buildSqlMapClient(reader);            
        } catch (IOException e) {
            throw e ;
        }           
    }
    
    public static DbOperationFactory newInstance() throws IOException {
		return newInstance(DEFAULT_CONFIG_FILE);
    } 
    
    /**
     * Creates a new instance with the specified file.
     * 
     * 
     * @param   file   The configure file.
     * @return  obj    The factory object.
     */
    public static DbOperationFactory newInstance(String file) throws IOException {
		return new DbOperationFactory(file);
    }     
    
    // singleton instance.
    private static DbOperationFactory sharedInstance = getSharedInstance() ;
    
    /**
     * Gets the shared instance.
     * 
     */
    public static DbOperationFactory getSharedInstance() {
         if(sharedInstance == null)
             try {
                 sharedInstance = newInstance();
             } catch (IOException e) {
            	 	e.printStackTrace();
             }             
         return sharedInstance ;    
    }
    
    public SqlMapClient getSqlMapClient() {
        return smc;  
    }
     
    public boolean isUseCache() {
 		return isUseCache;
 	}

 	public void setUseCache(boolean isUseCache) {
 		this.isUseCache = isUseCache;
 	}
} 
