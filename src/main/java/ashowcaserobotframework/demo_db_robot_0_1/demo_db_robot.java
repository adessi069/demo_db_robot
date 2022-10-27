
package ashowcaserobotframework.demo_db_robot_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 




	//the import part of tJava_1
	//import java.util.List;

	//the import part of tJava_2
	//import java.util.List;

	//the import part of tJava_3
	//import java.util.List;

	//the import part of tJava_4
	//import java.util.List;


@SuppressWarnings("unused")

/**
 * Job: demo_db_robot Purpose: Talend job for Robot demo<br>
 * Description: This job will grab two tables from PostgreSQL database, add the content and output the result. The output will get checked by the robot script again. <br>
 * @author Leyser, Mahapan
 * @version 8.0.1.20220923_1236-patch
 * @status 
 */
public class demo_db_robot implements TalendJob {
	static {System.setProperty("TalendJob.log", "demo_db_robot.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(demo_db_robot.class);
	

protected static void logIgnoredError(String message, Throwable cause) {
       log.error(message, cause);

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(demo_db_postgres_Server != null){
				
					this.setProperty("demo_db_postgres_Server", demo_db_postgres_Server.toString());
				
			}
			
			if(demo_db_postgres_Database != null){
				
					this.setProperty("demo_db_postgres_Database", demo_db_postgres_Database.toString());
				
			}
			
			if(demo_db_postgres_Login != null){
				
					this.setProperty("demo_db_postgres_Login", demo_db_postgres_Login.toString());
				
			}
			
			if(demo_db_postgres_Password != null){
				
					this.setProperty("demo_db_postgres_Password", demo_db_postgres_Password.toString());
				
			}
			
			if(demo_db_postgres_Port != null){
				
					this.setProperty("demo_db_postgres_Port", demo_db_postgres_Port.toString());
				
			}
			
			if(demo_db_postgres_AdditionalParams != null){
				
					this.setProperty("demo_db_postgres_AdditionalParams", demo_db_postgres_AdditionalParams.toString());
				
			}
			
			if(demo_db_postgres_Schema != null){
				
					this.setProperty("demo_db_postgres_Schema", demo_db_postgres_Schema.toString());
				
			}
			
			if(demo_db_table_in_0 != null){
				
					this.setProperty("demo_db_table_in_0", demo_db_table_in_0.toString());
				
			}
			
			if(demo_db_table_in_1 != null){
				
					this.setProperty("demo_db_table_in_1", demo_db_table_in_1.toString());
				
			}
			
			if(demo_db_table_out_0 != null){
				
					this.setProperty("demo_db_table_out_0", demo_db_table_out_0.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public String demo_db_postgres_Server;
public String getDemo_db_postgres_Server(){
	return this.demo_db_postgres_Server;
}
public String demo_db_postgres_Database;
public String getDemo_db_postgres_Database(){
	return this.demo_db_postgres_Database;
}
public String demo_db_postgres_Login;
public String getDemo_db_postgres_Login(){
	return this.demo_db_postgres_Login;
}
public java.lang.String demo_db_postgres_Password;
public java.lang.String getDemo_db_postgres_Password(){
	return this.demo_db_postgres_Password;
}
public String demo_db_postgres_Port;
public String getDemo_db_postgres_Port(){
	return this.demo_db_postgres_Port;
}
public String demo_db_postgres_AdditionalParams;
public String getDemo_db_postgres_AdditionalParams(){
	return this.demo_db_postgres_AdditionalParams;
}
public String demo_db_postgres_Schema;
public String getDemo_db_postgres_Schema(){
	return this.demo_db_postgres_Schema;
}
public String demo_db_table_in_0;
public String getDemo_db_table_in_0(){
	return this.demo_db_table_in_0;
}
public String demo_db_table_in_1;
public String getDemo_db_table_in_1(){
	return this.demo_db_table_in_1;
}
public String demo_db_table_out_0;
public String getDemo_db_table_out_0(){
	return this.demo_db_table_out_0;
}
	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "demo_db_robot";
	private final String projectName = "ASHOWCASEROBOTFRAMEWORK";
	public Integer errorCode = null;
	private String currentComponent = "";
	
	private String cLabel =  null;
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_3T3h8CRPEe2AouJ5Ky595w", "0.1");
private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	
	private String currentComponent = null;
	private String cLabel =  null;
	
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}
	
	private TalendException(Exception e, String errorComponent, String errorComponentLabel, final java.util.Map<String, Object> globalMap) {
		this(e, errorComponent, globalMap);
		this.cLabel = errorComponentLabel;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				demo_db_robot.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(demo_db_robot.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
		if(enableLogStash) {
			talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
			talendJobLogProcess(globalMap);
		}
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tPrejob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBConnection_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
						try {
							
								if(this.execStat){
									runStat.updateStatOnConnection("OnComponentError1", 0, "error");
								}
							
							
								errorCode = null;
								tJava_2Process(globalMap);
								if (!"failure".equals(status)) {
									status = "end";
								}
								

						} catch (Exception e) {
							e.printStackTrace();
						}
						
					tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJava_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJava_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tUnite_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tUniqRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
						try {
							
								if(this.execStat){
									runStat.updateStatOnConnection("OnComponentError2", 0, "error");
								}
							
							
								errorCode = null;
								tDBRollback_1Process(globalMap);
								if (!"failure".equals(status)) {
									status = "end";
								}
								

						} catch (Exception e) {
							e.printStackTrace();
						}
						
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBCommit_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBCommit_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJava_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBRollback_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBRollback_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJava_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPostjob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBClose_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBClose_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPrejob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBCommit_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBRollback_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPostjob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBClose_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void talendJobLog_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	


public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "tPrejob_1");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPrejob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPrejob_1", false);
		start_Hash.put("tPrejob_1", System.currentTimeMillis());
		
	
	currentComponent="tPrejob_1";
	
	
		int tos_count_tPrejob_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tPrejob_1", "tPrejob_1", "tPrejob");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tPrejob_1 begin ] stop
 */
	
	/**
	 * [tPrejob_1 main ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 


	tos_count_tPrejob_1++;

/**
 * [tPrejob_1 main ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 



/**
 * [tPrejob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 



/**
 * [tPrejob_1 process_data_end ] stop
 */
	
	/**
	 * [tPrejob_1 end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 

ok_Hash.put("tPrejob_1", true);
end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBConnection_1Process(globalMap);



/**
 * [tPrejob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPrejob_1 finally ] start
	 */

	

	
	
	currentComponent="tPrejob_1";
	
	

 



/**
 * [tPrejob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "tDBConnection_1");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBConnection_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBConnection_1", false);
		start_Hash.put("tDBConnection_1", System.currentTimeMillis());
		
	
	currentComponent="tDBConnection_1";
	
	
		int tos_count_tDBConnection_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBConnection_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBConnection_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBConnection_1 = new StringBuilder();
                    log4jParamters_tDBConnection_1.append("Parameters:");
                            log4jParamters_tDBConnection_1.append("DB_VERSION" + " = " + "V9_X");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("HOST" + " = " + "context.demo_db_postgres_Server");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("PORT" + " = " + "context.demo_db_postgres_Port");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("DBNAME" + " = " + "context.demo_db_postgres_Database");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("SCHEMA_DB" + " = " + "context.demo_db_postgres_Schema");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("USER" + " = " + "context.demo_db_postgres_Login");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("PASS" + " = " + String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(context.demo_db_postgres_Password)).substring(0, 4) + "...");     
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("USE_SHARED_CONNECTION" + " = " + "false");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("PROPERTIES" + " = " + "\"serverTimezone=Europe/Rome\"");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("AUTO_COMMIT" + " = " + "false");
                        log4jParamters_tDBConnection_1.append(" | ");
                            log4jParamters_tDBConnection_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlConnection");
                        log4jParamters_tDBConnection_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBConnection_1 - "  + (log4jParamters_tDBConnection_1) );
                    } 
                } 
            new BytesLimit65535_tDBConnection_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBConnection_1", "tDBConnection_1", "tPostgresqlConnection");
				talendJobLogProcess(globalMap);
			}
			


	
            String dbProperties_tDBConnection_1 = "serverTimezone=Europe/Rome";
            String url_tDBConnection_1 = "jdbc:postgresql://"+context.demo_db_postgres_Server+":"+context.demo_db_postgres_Port+"/"+context.demo_db_postgres_Database;
            
            if(dbProperties_tDBConnection_1 != null && !"".equals(dbProperties_tDBConnection_1.trim())) {
                url_tDBConnection_1 = url_tDBConnection_1 + "?" + dbProperties_tDBConnection_1;
            }
	String dbUser_tDBConnection_1 = context.demo_db_postgres_Login;
	
	
		
	final String decryptedPassword_tDBConnection_1 = context.demo_db_postgres_Password; 
		String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;
	
	
	java.sql.Connection conn_tDBConnection_1 = null;
	
        java.util.Enumeration<java.sql.Driver> drivers_tDBConnection_1 =  java.sql.DriverManager.getDrivers();
        java.util.Set<String> redShiftDriverNames_tDBConnection_1 = new java.util.HashSet<String>(java.util.Arrays
                .asList("com.amazon.redshift.jdbc.Driver","com.amazon.redshift.jdbc41.Driver","com.amazon.redshift.jdbc42.Driver"));
    while (drivers_tDBConnection_1.hasMoreElements()) {
        java.sql.Driver d_tDBConnection_1 = drivers_tDBConnection_1.nextElement();
        if (redShiftDriverNames_tDBConnection_1.contains(d_tDBConnection_1.getClass().getName())) {
            try {
                java.sql.DriverManager.deregisterDriver(d_tDBConnection_1);
                java.sql.DriverManager.registerDriver(d_tDBConnection_1);
            } catch (java.lang.Exception e_tDBConnection_1) {
globalMap.put("tDBConnection_1_ERROR_MESSAGE",e_tDBConnection_1.getMessage());
                    //do nothing
            }
        }
    }
					String driverClass_tDBConnection_1 = "org.postgresql.Driver";
			java.lang.Class jdbcclazz_tDBConnection_1 = java.lang.Class.forName(driverClass_tDBConnection_1);
			globalMap.put("driverClass_tDBConnection_1", driverClass_tDBConnection_1);
		
	    		log.debug("tDBConnection_1 - Driver ClassName: "+driverClass_tDBConnection_1+".");
			
	    		log.debug("tDBConnection_1 - Connection attempt to '" + url_tDBConnection_1 + "' with the username '" + dbUser_tDBConnection_1 + "'.");
			
			conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1,dbUser_tDBConnection_1,dbPwd_tDBConnection_1);
	    		log.debug("tDBConnection_1 - Connection to '" + url_tDBConnection_1 + "' has succeeded.");
			

		globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
	if (null != conn_tDBConnection_1) {
		
			log.debug("tDBConnection_1 - Connection is set auto commit to 'false'.");
			conn_tDBConnection_1.setAutoCommit(false);
	}

	globalMap.put("schema_" + "tDBConnection_1",context.demo_db_postgres_Schema);

 



/**
 * [tDBConnection_1 begin ] stop
 */
	
	/**
	 * [tDBConnection_1 main ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";
	
	

 


	tos_count_tDBConnection_1++;

/**
 * [tDBConnection_1 main ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";
	
	

 



/**
 * [tDBConnection_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";
	
	

 



/**
 * [tDBConnection_1 process_data_end ] stop
 */
	
	/**
	 * [tDBConnection_1 end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";
	
	

 
                if(log.isDebugEnabled())
            log.debug("tDBConnection_1 - "  + ("Done.") );

ok_Hash.put("tDBConnection_1", true);
end_Hash.put("tDBConnection_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tJava_1Process(globalMap);



/**
 * [tDBConnection_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBConnection_1 finally ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";
	
	

 



/**
 * [tDBConnection_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "tJava_1");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tJava_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_1", false);
		start_Hash.put("tJava_1", System.currentTimeMillis());
		
	
	currentComponent="tJava_1";
	
	
		int tos_count_tJava_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tJava_1", "tJava_1", "tJava");
				talendJobLogProcess(globalMap);
			}
			


System.out.println("\nConnection to the database established.\n");
 



/**
 * [tJava_1 begin ] stop
 */
	
	/**
	 * [tJava_1 main ] start
	 */

	

	
	
	currentComponent="tJava_1";
	
	

 


	tos_count_tJava_1++;

/**
 * [tJava_1 main ] stop
 */
	
	/**
	 * [tJava_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_1";
	
	

 



/**
 * [tJava_1 process_data_begin ] stop
 */
	
	/**
	 * [tJava_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_1";
	
	

 



/**
 * [tJava_1 process_data_end ] stop
 */
	
	/**
	 * [tJava_1 end ] start
	 */

	

	
	
	currentComponent="tJava_1";
	
	

 

ok_Hash.put("tJava_1", true);
end_Hash.put("tJava_1", System.currentTimeMillis());




/**
 * [tJava_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_1 finally ] start
	 */

	

	
	
	currentComponent="tJava_1";
	
	

 



/**
 * [tJava_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "tJava_2");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tJava_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_2", false);
		start_Hash.put("tJava_2", System.currentTimeMillis());
		
	
	currentComponent="tJava_2";
	
	
		int tos_count_tJava_2 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tJava_2", "tJava_2", "tJava");
				talendJobLogProcess(globalMap);
			}
			


System.out.println("\nConnection to the database failed.\n");
 



/**
 * [tJava_2 begin ] stop
 */
	
	/**
	 * [tJava_2 main ] start
	 */

	

	
	
	currentComponent="tJava_2";
	
	

 


	tos_count_tJava_2++;

/**
 * [tJava_2 main ] stop
 */
	
	/**
	 * [tJava_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_2";
	
	

 



/**
 * [tJava_2 process_data_begin ] stop
 */
	
	/**
	 * [tJava_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_2";
	
	

 



/**
 * [tJava_2 process_data_end ] stop
 */
	
	/**
	 * [tJava_2 end ] start
	 */

	

	
	
	currentComponent="tJava_2";
	
	

 

ok_Hash.put("tJava_2", true);
end_Hash.put("tJava_2", System.currentTimeMillis());




/**
 * [tJava_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_2 finally ] start
	 */

	

	
	
	currentComponent="tJava_2";
	
	

 



/**
 * [tJava_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_2_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
    final static byte[] commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[0];
    static byte[] commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[0];

	
			    public Integer version_id;

				public Integer getVersion_id () {
					return this.version_id;
				}

				public Boolean version_idIsNullable(){
				    return true;
				}
				public Boolean version_idIsKey(){
				    return false;
				}
				public Integer version_idLength(){
				    return null;
				}
				public Integer version_idPrecision(){
				    return null;
				}
				public String version_idDefault(){
				
					return null;
				
				}
				public String version_idComment(){
				
				    return "";
				
				}
				public String version_idPattern(){
				
					return "";
				
				}
				public String version_idOriginalDbColumnName(){
				
					return "version_id";
				
				}

				
			    public String object_id;

				public String getObject_id () {
					return this.object_id;
				}

				public Boolean object_idIsNullable(){
				    return true;
				}
				public Boolean object_idIsKey(){
				    return false;
				}
				public Integer object_idLength(){
				    return null;
				}
				public Integer object_idPrecision(){
				    return null;
				}
				public String object_idDefault(){
				
					return null;
				
				}
				public String object_idComment(){
				
				    return "";
				
				}
				public String object_idPattern(){
				
					return "";
				
				}
				public String object_idOriginalDbColumnName(){
				
					return "object_id";
				
				}

				
			    public String vorname;

				public String getVorname () {
					return this.vorname;
				}

				public Boolean vornameIsNullable(){
				    return true;
				}
				public Boolean vornameIsKey(){
				    return false;
				}
				public Integer vornameLength(){
				    return null;
				}
				public Integer vornamePrecision(){
				    return null;
				}
				public String vornameDefault(){
				
					return null;
				
				}
				public String vornameComment(){
				
				    return "";
				
				}
				public String vornamePattern(){
				
					return "";
				
				}
				public String vornameOriginalDbColumnName(){
				
					return "vorname";
				
				}

				
			    public String nachname;

				public String getNachname () {
					return this.nachname;
				}

				public Boolean nachnameIsNullable(){
				    return true;
				}
				public Boolean nachnameIsKey(){
				    return false;
				}
				public Integer nachnameLength(){
				    return null;
				}
				public Integer nachnamePrecision(){
				    return null;
				}
				public String nachnameDefault(){
				
					return null;
				
				}
				public String nachnameComment(){
				
				    return "";
				
				}
				public String nachnamePattern(){
				
					return "";
				
				}
				public String nachnameOriginalDbColumnName(){
				
					return "nachname";
				
				}

				
			    public java.util.Date gueltig_von;

				public java.util.Date getGueltig_von () {
					return this.gueltig_von;
				}

				public Boolean gueltig_vonIsNullable(){
				    return true;
				}
				public Boolean gueltig_vonIsKey(){
				    return false;
				}
				public Integer gueltig_vonLength(){
				    return null;
				}
				public Integer gueltig_vonPrecision(){
				    return null;
				}
				public String gueltig_vonDefault(){
				
					return null;
				
				}
				public String gueltig_vonComment(){
				
				    return "";
				
				}
				public String gueltig_vonPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String gueltig_vonOriginalDbColumnName(){
				
					return "gueltig_von";
				
				}

				
			    public java.util.Date gueltig_bis;

				public java.util.Date getGueltig_bis () {
					return this.gueltig_bis;
				}

				public Boolean gueltig_bisIsNullable(){
				    return true;
				}
				public Boolean gueltig_bisIsKey(){
				    return false;
				}
				public Integer gueltig_bisLength(){
				    return null;
				}
				public Integer gueltig_bisPrecision(){
				    return null;
				}
				public String gueltig_bisDefault(){
				
					return null;
				
				}
				public String gueltig_bisComment(){
				
				    return "";
				
				}
				public String gueltig_bisPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String gueltig_bisOriginalDbColumnName(){
				
					return "gueltig_bis";
				
				}

				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length) {
				if(length < 1024 && commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length == 0) {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[1024];
				} else {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length);
			strReturn = new String(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length) {
				if(length < 1024 && commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length == 0) {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[1024];
				} else {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length);
			strReturn = new String(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot) {

        	try {

        		int length = 0;
		
						this.version_id = readInteger(dis);
					
					this.object_id = readString(dis);
					
					this.vorname = readString(dis);
					
					this.nachname = readString(dis);
					
					this.gueltig_von = readDate(dis);
					
					this.gueltig_bis = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot) {

        	try {

        		int length = 0;
		
						this.version_id = readInteger(dis);
					
					this.object_id = readString(dis);
					
					this.vorname = readString(dis);
					
					this.nachname = readString(dis);
					
					this.gueltig_von = readDate(dis);
					
					this.gueltig_bis = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.version_id,dos);
					
					// String
				
						writeString(this.object_id,dos);
					
					// String
				
						writeString(this.vorname,dos);
					
					// String
				
						writeString(this.nachname,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_von,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_bis,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.version_id,dos);
					
					// String
				
						writeString(this.object_id,dos);
					
					// String
				
						writeString(this.vorname,dos);
					
					// String
				
						writeString(this.nachname,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_von,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_bis,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("version_id="+String.valueOf(version_id));
		sb.append(",object_id="+object_id);
		sb.append(",vorname="+vorname);
		sb.append(",nachname="+nachname);
		sb.append(",gueltig_von="+String.valueOf(gueltig_von));
		sb.append(",gueltig_bis="+String.valueOf(gueltig_bis));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(version_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(version_id);
            			}
            		
        			sb.append("|");
        		
        				if(object_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(object_id);
            			}
            		
        			sb.append("|");
        		
        				if(vorname == null){
        					sb.append("<null>");
        				}else{
            				sb.append(vorname);
            			}
            		
        			sb.append("|");
        		
        				if(nachname == null){
        					sb.append("<null>");
        				}else{
            				sb.append(nachname);
            			}
            		
        			sb.append("|");
        		
        				if(gueltig_von == null){
        					sb.append("<null>");
        				}else{
            				sb.append(gueltig_von);
            			}
            		
        			sb.append("|");
        		
        				if(gueltig_bis == null){
        					sb.append("<null>");
        				}else{
            				sb.append(gueltig_bis);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[0];
    static byte[] commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[0];

	
			    public Integer version_id;

				public Integer getVersion_id () {
					return this.version_id;
				}

				public Boolean version_idIsNullable(){
				    return true;
				}
				public Boolean version_idIsKey(){
				    return false;
				}
				public Integer version_idLength(){
				    return null;
				}
				public Integer version_idPrecision(){
				    return null;
				}
				public String version_idDefault(){
				
					return null;
				
				}
				public String version_idComment(){
				
				    return "";
				
				}
				public String version_idPattern(){
				
					return "";
				
				}
				public String version_idOriginalDbColumnName(){
				
					return "version_id";
				
				}

				
			    public String object_id;

				public String getObject_id () {
					return this.object_id;
				}

				public Boolean object_idIsNullable(){
				    return true;
				}
				public Boolean object_idIsKey(){
				    return false;
				}
				public Integer object_idLength(){
				    return null;
				}
				public Integer object_idPrecision(){
				    return null;
				}
				public String object_idDefault(){
				
					return null;
				
				}
				public String object_idComment(){
				
				    return "";
				
				}
				public String object_idPattern(){
				
					return "";
				
				}
				public String object_idOriginalDbColumnName(){
				
					return "object_id";
				
				}

				
			    public String vorname;

				public String getVorname () {
					return this.vorname;
				}

				public Boolean vornameIsNullable(){
				    return true;
				}
				public Boolean vornameIsKey(){
				    return false;
				}
				public Integer vornameLength(){
				    return null;
				}
				public Integer vornamePrecision(){
				    return null;
				}
				public String vornameDefault(){
				
					return null;
				
				}
				public String vornameComment(){
				
				    return "";
				
				}
				public String vornamePattern(){
				
					return "";
				
				}
				public String vornameOriginalDbColumnName(){
				
					return "vorname";
				
				}

				
			    public String nachname;

				public String getNachname () {
					return this.nachname;
				}

				public Boolean nachnameIsNullable(){
				    return true;
				}
				public Boolean nachnameIsKey(){
				    return false;
				}
				public Integer nachnameLength(){
				    return null;
				}
				public Integer nachnamePrecision(){
				    return null;
				}
				public String nachnameDefault(){
				
					return null;
				
				}
				public String nachnameComment(){
				
				    return "";
				
				}
				public String nachnamePattern(){
				
					return "";
				
				}
				public String nachnameOriginalDbColumnName(){
				
					return "nachname";
				
				}

				
			    public java.util.Date gueltig_von;

				public java.util.Date getGueltig_von () {
					return this.gueltig_von;
				}

				public Boolean gueltig_vonIsNullable(){
				    return true;
				}
				public Boolean gueltig_vonIsKey(){
				    return false;
				}
				public Integer gueltig_vonLength(){
				    return null;
				}
				public Integer gueltig_vonPrecision(){
				    return null;
				}
				public String gueltig_vonDefault(){
				
					return null;
				
				}
				public String gueltig_vonComment(){
				
				    return "";
				
				}
				public String gueltig_vonPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String gueltig_vonOriginalDbColumnName(){
				
					return "gueltig_von";
				
				}

				
			    public java.util.Date gueltig_bis;

				public java.util.Date getGueltig_bis () {
					return this.gueltig_bis;
				}

				public Boolean gueltig_bisIsNullable(){
				    return true;
				}
				public Boolean gueltig_bisIsKey(){
				    return false;
				}
				public Integer gueltig_bisLength(){
				    return null;
				}
				public Integer gueltig_bisPrecision(){
				    return null;
				}
				public String gueltig_bisDefault(){
				
					return null;
				
				}
				public String gueltig_bisComment(){
				
				    return "";
				
				}
				public String gueltig_bisPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String gueltig_bisOriginalDbColumnName(){
				
					return "gueltig_bis";
				
				}

				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length) {
				if(length < 1024 && commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length == 0) {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[1024];
				} else {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length);
			strReturn = new String(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length) {
				if(length < 1024 && commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length == 0) {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[1024];
				} else {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length);
			strReturn = new String(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot) {

        	try {

        		int length = 0;
		
						this.version_id = readInteger(dis);
					
					this.object_id = readString(dis);
					
					this.vorname = readString(dis);
					
					this.nachname = readString(dis);
					
					this.gueltig_von = readDate(dis);
					
					this.gueltig_bis = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot) {

        	try {

        		int length = 0;
		
						this.version_id = readInteger(dis);
					
					this.object_id = readString(dis);
					
					this.vorname = readString(dis);
					
					this.nachname = readString(dis);
					
					this.gueltig_von = readDate(dis);
					
					this.gueltig_bis = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.version_id,dos);
					
					// String
				
						writeString(this.object_id,dos);
					
					// String
				
						writeString(this.vorname,dos);
					
					// String
				
						writeString(this.nachname,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_von,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_bis,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.version_id,dos);
					
					// String
				
						writeString(this.object_id,dos);
					
					// String
				
						writeString(this.vorname,dos);
					
					// String
				
						writeString(this.nachname,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_von,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_bis,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("version_id="+String.valueOf(version_id));
		sb.append(",object_id="+object_id);
		sb.append(",vorname="+vorname);
		sb.append(",nachname="+nachname);
		sb.append(",gueltig_von="+String.valueOf(gueltig_von));
		sb.append(",gueltig_bis="+String.valueOf(gueltig_bis));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(version_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(version_id);
            			}
            		
        			sb.append("|");
        		
        				if(object_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(object_id);
            			}
            		
        			sb.append("|");
        		
        				if(vorname == null){
        					sb.append("<null>");
        				}else{
            				sb.append(vorname);
            			}
            		
        			sb.append("|");
        		
        				if(nachname == null){
        					sb.append("<null>");
        				}else{
            				sb.append(nachname);
            			}
            		
        			sb.append("|");
        		
        				if(gueltig_von == null){
        					sb.append("<null>");
        				}else{
            				sb.append(gueltig_von);
            			}
            		
        			sb.append("|");
        		
        				if(gueltig_bis == null){
        					sb.append("<null>");
        				}else{
            				sb.append(gueltig_bis);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[0];
    static byte[] commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[0];

	
			    public Integer version_id;

				public Integer getVersion_id () {
					return this.version_id;
				}

				public Boolean version_idIsNullable(){
				    return true;
				}
				public Boolean version_idIsKey(){
				    return false;
				}
				public Integer version_idLength(){
				    return null;
				}
				public Integer version_idPrecision(){
				    return null;
				}
				public String version_idDefault(){
				
					return null;
				
				}
				public String version_idComment(){
				
				    return "";
				
				}
				public String version_idPattern(){
				
					return "";
				
				}
				public String version_idOriginalDbColumnName(){
				
					return "version_id";
				
				}

				
			    public String object_id;

				public String getObject_id () {
					return this.object_id;
				}

				public Boolean object_idIsNullable(){
				    return true;
				}
				public Boolean object_idIsKey(){
				    return false;
				}
				public Integer object_idLength(){
				    return null;
				}
				public Integer object_idPrecision(){
				    return null;
				}
				public String object_idDefault(){
				
					return null;
				
				}
				public String object_idComment(){
				
				    return "";
				
				}
				public String object_idPattern(){
				
					return "";
				
				}
				public String object_idOriginalDbColumnName(){
				
					return "object_id";
				
				}

				
			    public String vorname;

				public String getVorname () {
					return this.vorname;
				}

				public Boolean vornameIsNullable(){
				    return true;
				}
				public Boolean vornameIsKey(){
				    return false;
				}
				public Integer vornameLength(){
				    return null;
				}
				public Integer vornamePrecision(){
				    return null;
				}
				public String vornameDefault(){
				
					return null;
				
				}
				public String vornameComment(){
				
				    return "";
				
				}
				public String vornamePattern(){
				
					return "";
				
				}
				public String vornameOriginalDbColumnName(){
				
					return "vorname";
				
				}

				
			    public String nachname;

				public String getNachname () {
					return this.nachname;
				}

				public Boolean nachnameIsNullable(){
				    return true;
				}
				public Boolean nachnameIsKey(){
				    return false;
				}
				public Integer nachnameLength(){
				    return null;
				}
				public Integer nachnamePrecision(){
				    return null;
				}
				public String nachnameDefault(){
				
					return null;
				
				}
				public String nachnameComment(){
				
				    return "";
				
				}
				public String nachnamePattern(){
				
					return "";
				
				}
				public String nachnameOriginalDbColumnName(){
				
					return "nachname";
				
				}

				
			    public java.util.Date gueltig_von;

				public java.util.Date getGueltig_von () {
					return this.gueltig_von;
				}

				public Boolean gueltig_vonIsNullable(){
				    return true;
				}
				public Boolean gueltig_vonIsKey(){
				    return false;
				}
				public Integer gueltig_vonLength(){
				    return null;
				}
				public Integer gueltig_vonPrecision(){
				    return null;
				}
				public String gueltig_vonDefault(){
				
					return null;
				
				}
				public String gueltig_vonComment(){
				
				    return "";
				
				}
				public String gueltig_vonPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String gueltig_vonOriginalDbColumnName(){
				
					return "gueltig_von";
				
				}

				
			    public java.util.Date gueltig_bis;

				public java.util.Date getGueltig_bis () {
					return this.gueltig_bis;
				}

				public Boolean gueltig_bisIsNullable(){
				    return true;
				}
				public Boolean gueltig_bisIsKey(){
				    return false;
				}
				public Integer gueltig_bisLength(){
				    return null;
				}
				public Integer gueltig_bisPrecision(){
				    return null;
				}
				public String gueltig_bisDefault(){
				
					return null;
				
				}
				public String gueltig_bisComment(){
				
				    return "";
				
				}
				public String gueltig_bisPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String gueltig_bisOriginalDbColumnName(){
				
					return "gueltig_bis";
				
				}

				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length) {
				if(length < 1024 && commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length == 0) {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[1024];
				} else {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length);
			strReturn = new String(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length) {
				if(length < 1024 && commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length == 0) {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[1024];
				} else {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length);
			strReturn = new String(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot) {

        	try {

        		int length = 0;
		
						this.version_id = readInteger(dis);
					
					this.object_id = readString(dis);
					
					this.vorname = readString(dis);
					
					this.nachname = readString(dis);
					
					this.gueltig_von = readDate(dis);
					
					this.gueltig_bis = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot) {

        	try {

        		int length = 0;
		
						this.version_id = readInteger(dis);
					
					this.object_id = readString(dis);
					
					this.vorname = readString(dis);
					
					this.nachname = readString(dis);
					
					this.gueltig_von = readDate(dis);
					
					this.gueltig_bis = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.version_id,dos);
					
					// String
				
						writeString(this.object_id,dos);
					
					// String
				
						writeString(this.vorname,dos);
					
					// String
				
						writeString(this.nachname,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_von,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_bis,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.version_id,dos);
					
					// String
				
						writeString(this.object_id,dos);
					
					// String
				
						writeString(this.vorname,dos);
					
					// String
				
						writeString(this.nachname,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_von,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_bis,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("version_id="+String.valueOf(version_id));
		sb.append(",object_id="+object_id);
		sb.append(",vorname="+vorname);
		sb.append(",nachname="+nachname);
		sb.append(",gueltig_von="+String.valueOf(gueltig_von));
		sb.append(",gueltig_bis="+String.valueOf(gueltig_bis));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(version_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(version_id);
            			}
            		
        			sb.append("|");
        		
        				if(object_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(object_id);
            			}
            		
        			sb.append("|");
        		
        				if(vorname == null){
        					sb.append("<null>");
        				}else{
            				sb.append(vorname);
            			}
            		
        			sb.append("|");
        		
        				if(nachname == null){
        					sb.append("<null>");
        				}else{
            				sb.append(nachname);
            			}
            		
        			sb.append("|");
        		
        				if(gueltig_von == null){
        					sb.append("<null>");
        				}else{
            				sb.append(gueltig_von);
            			}
            		
        			sb.append("|");
        		
        				if(gueltig_bis == null){
        					sb.append("<null>");
        				}else{
            				sb.append(gueltig_bis);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[0];
    static byte[] commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[0];

	
			    public Integer version_id;

				public Integer getVersion_id () {
					return this.version_id;
				}

				public Boolean version_idIsNullable(){
				    return true;
				}
				public Boolean version_idIsKey(){
				    return false;
				}
				public Integer version_idLength(){
				    return null;
				}
				public Integer version_idPrecision(){
				    return null;
				}
				public String version_idDefault(){
				
					return null;
				
				}
				public String version_idComment(){
				
				    return "";
				
				}
				public String version_idPattern(){
				
					return "";
				
				}
				public String version_idOriginalDbColumnName(){
				
					return "version_id";
				
				}

				
			    public String object_id;

				public String getObject_id () {
					return this.object_id;
				}

				public Boolean object_idIsNullable(){
				    return true;
				}
				public Boolean object_idIsKey(){
				    return false;
				}
				public Integer object_idLength(){
				    return null;
				}
				public Integer object_idPrecision(){
				    return null;
				}
				public String object_idDefault(){
				
					return null;
				
				}
				public String object_idComment(){
				
				    return "";
				
				}
				public String object_idPattern(){
				
					return "";
				
				}
				public String object_idOriginalDbColumnName(){
				
					return "object_id";
				
				}

				
			    public String vorname;

				public String getVorname () {
					return this.vorname;
				}

				public Boolean vornameIsNullable(){
				    return true;
				}
				public Boolean vornameIsKey(){
				    return false;
				}
				public Integer vornameLength(){
				    return null;
				}
				public Integer vornamePrecision(){
				    return null;
				}
				public String vornameDefault(){
				
					return null;
				
				}
				public String vornameComment(){
				
				    return "";
				
				}
				public String vornamePattern(){
				
					return "";
				
				}
				public String vornameOriginalDbColumnName(){
				
					return "vorname";
				
				}

				
			    public String nachname;

				public String getNachname () {
					return this.nachname;
				}

				public Boolean nachnameIsNullable(){
				    return true;
				}
				public Boolean nachnameIsKey(){
				    return false;
				}
				public Integer nachnameLength(){
				    return null;
				}
				public Integer nachnamePrecision(){
				    return null;
				}
				public String nachnameDefault(){
				
					return null;
				
				}
				public String nachnameComment(){
				
				    return "";
				
				}
				public String nachnamePattern(){
				
					return "";
				
				}
				public String nachnameOriginalDbColumnName(){
				
					return "nachname";
				
				}

				
			    public java.util.Date gueltig_von;

				public java.util.Date getGueltig_von () {
					return this.gueltig_von;
				}

				public Boolean gueltig_vonIsNullable(){
				    return true;
				}
				public Boolean gueltig_vonIsKey(){
				    return false;
				}
				public Integer gueltig_vonLength(){
				    return null;
				}
				public Integer gueltig_vonPrecision(){
				    return null;
				}
				public String gueltig_vonDefault(){
				
					return null;
				
				}
				public String gueltig_vonComment(){
				
				    return "";
				
				}
				public String gueltig_vonPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String gueltig_vonOriginalDbColumnName(){
				
					return "gueltig_von";
				
				}

				
			    public java.util.Date gueltig_bis;

				public java.util.Date getGueltig_bis () {
					return this.gueltig_bis;
				}

				public Boolean gueltig_bisIsNullable(){
				    return true;
				}
				public Boolean gueltig_bisIsKey(){
				    return false;
				}
				public Integer gueltig_bisLength(){
				    return null;
				}
				public Integer gueltig_bisPrecision(){
				    return null;
				}
				public String gueltig_bisDefault(){
				
					return null;
				
				}
				public String gueltig_bisComment(){
				
				    return "";
				
				}
				public String gueltig_bisPattern(){
				
					return "dd-MM-yyyy";
				
				}
				public String gueltig_bisOriginalDbColumnName(){
				
					return "gueltig_bis";
				
				}

				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length) {
				if(length < 1024 && commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length == 0) {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[1024];
				} else {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length);
			strReturn = new String(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length) {
				if(length < 1024 && commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot.length == 0) {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[1024];
				} else {
   					commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length);
			strReturn = new String(commonByteArray_ASHOWCASEROBOTFRAMEWORK_demo_db_robot, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot) {

        	try {

        		int length = 0;
		
						this.version_id = readInteger(dis);
					
					this.object_id = readString(dis);
					
					this.vorname = readString(dis);
					
					this.nachname = readString(dis);
					
					this.gueltig_von = readDate(dis);
					
					this.gueltig_bis = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ASHOWCASEROBOTFRAMEWORK_demo_db_robot) {

        	try {

        		int length = 0;
		
						this.version_id = readInteger(dis);
					
					this.object_id = readString(dis);
					
					this.vorname = readString(dis);
					
					this.nachname = readString(dis);
					
					this.gueltig_von = readDate(dis);
					
					this.gueltig_bis = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.version_id,dos);
					
					// String
				
						writeString(this.object_id,dos);
					
					// String
				
						writeString(this.vorname,dos);
					
					// String
				
						writeString(this.nachname,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_von,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_bis,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.version_id,dos);
					
					// String
				
						writeString(this.object_id,dos);
					
					// String
				
						writeString(this.vorname,dos);
					
					// String
				
						writeString(this.nachname,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_von,dos);
					
					// java.util.Date
				
						writeDate(this.gueltig_bis,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("version_id="+String.valueOf(version_id));
		sb.append(",object_id="+object_id);
		sb.append(",vorname="+vorname);
		sb.append(",nachname="+nachname);
		sb.append(",gueltig_von="+String.valueOf(gueltig_von));
		sb.append(",gueltig_bis="+String.valueOf(gueltig_bis));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(version_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(version_id);
            			}
            		
        			sb.append("|");
        		
        				if(object_id == null){
        					sb.append("<null>");
        				}else{
            				sb.append(object_id);
            			}
            		
        			sb.append("|");
        		
        				if(vorname == null){
        					sb.append("<null>");
        				}else{
            				sb.append(vorname);
            			}
            		
        			sb.append("|");
        		
        				if(nachname == null){
        					sb.append("<null>");
        				}else{
            				sb.append(nachname);
            			}
            		
        			sb.append("|");
        		
        				if(gueltig_von == null){
        					sb.append("<null>");
        				}else{
            				sb.append(gueltig_von);
            			}
            		
        			sb.append("|");
        		
        				if(gueltig_bis == null){
        					sb.append("<null>");
        				}else{
            				sb.append(gueltig_bis);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "tDBInput_1");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();

		row2Struct row2 = new row2Struct();

			row3Struct row3 = new row3Struct();
row4Struct row4 = new row4Struct();





	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row4");
			
		int tos_count_tDBOutput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBOutput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
                    log4jParamters_tDBOutput_1.append("Parameters:");
                            log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("CONNECTION" + " = " + "tDBConnection_1");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("TABLE" + " = " + "context.demo_db_table_out_0");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "DROP_IF_EXISTS_AND_CREATE");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "INSERT");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_SPATIAL_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "true");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_ALTERNATE_SCHEMA" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("SUPPORT_NULL_WHERE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("CONVERT_COLUMN_TABLE_TO_LOWERCASE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_BATCH_SIZE" + " = " + "true");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("BATCH_SIZE" + " = " + "10000");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlOutput");
                        log4jParamters_tDBOutput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + (log4jParamters_tDBOutput_1) );
                    } 
                } 
            new BytesLimit65535_tDBOutput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBOutput_1", "tDBOutput_1", "tPostgresqlOutput");
				talendJobLogProcess(globalMap);
			}
			





String dbschema_tDBOutput_1 = null;
	dbschema_tDBOutput_1 = (String)globalMap.get("schema_" + "tDBConnection_1");
	

String tableName_tDBOutput_1 = null;
if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
	tableName_tDBOutput_1 = (context.demo_db_table_out_0);
} else {
	tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + (context.demo_db_table_out_0);
}


int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

boolean whetherReject_tDBOutput_1 = false;

java.sql.Connection conn_tDBOutput_1 = null;
String dbUser_tDBOutput_1 = null;

	conn_tDBOutput_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Uses an existing connection with username '")  + (conn_tDBOutput_1.getMetaData().getUserName())  + ("'. Connection URL: ")  + (conn_tDBOutput_1.getMetaData().getURL())  + (".") );
	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection is set auto commit to '")  + (conn_tDBOutput_1.getAutoCommit())  + ("'.") );


   int batchSize_tDBOutput_1 = 10000;
   int batchSizeCounter_tDBOutput_1=0;

int count_tDBOutput_1=0;
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_1 = conn_tDBOutput_1.getMetaData();
                                boolean whetherExist_tDBOutput_1 = false;
                                try (java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables(null, null, null, new String[]{"TABLE"})) {
                                    String defaultSchema_tDBOutput_1 = "public";
                                    if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
                                        try(java.sql.Statement stmtSchema_tDBOutput_1 = conn_tDBOutput_1.createStatement();
                                            java.sql.ResultSet rsSchema_tDBOutput_1 = stmtSchema_tDBOutput_1.executeQuery("select current_schema() ")) {
                                            while(rsSchema_tDBOutput_1.next()){
                                                defaultSchema_tDBOutput_1 = rsSchema_tDBOutput_1.getString("current_schema");
                                            }
                                        }
                                    }
                                    while(rsTable_tDBOutput_1.next()) {
                                        String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
                                        String schema_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_SCHEM");
                                        if(table_tDBOutput_1.equals((context.demo_db_table_out_0))
                                            && (schema_tDBOutput_1.equals(dbschema_tDBOutput_1) || ((dbschema_tDBOutput_1 ==null || dbschema_tDBOutput_1.trim().length() ==0) && defaultSchema_tDBOutput_1.equals(schema_tDBOutput_1)))) {
                                            whetherExist_tDBOutput_1 = true;
                                            break;
                                        }
                                    }
                                }
                                if(whetherExist_tDBOutput_1) {
                                    try (java.sql.Statement stmtDrop_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Dropping")  + (" table '")  + ("\"" +tableName_tDBOutput_1+ "\"")  + ("'.") );
                                        stmtDrop_tDBOutput_1.execute("DROP TABLE \"" + tableName_tDBOutput_1 + "\"" );
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Drop")  + (" table '")  + ("\"" +tableName_tDBOutput_1+ "\"")  + ("' has succeeded.") );
                                    }
                                }
                                try(java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Creating")  + (" table '")  + ("\"" +tableName_tDBOutput_1+ "\"")  + ("'.") );
                                    stmtCreate_tDBOutput_1.execute("CREATE TABLE \"" + tableName_tDBOutput_1 + "\"(\"version_id\" INT4 ,\"object_id\" VARCHAR ,\"vorname\" VARCHAR ,\"nachname\" VARCHAR ,\"gueltig_von\" DATE ,\"gueltig_bis\" DATE )");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Create")  + (" table '")  + ("\"" +tableName_tDBOutput_1+ "\"")  + ("' has succeeded.") );
                                }
        java.lang.StringBuilder sb_tDBOutput_1 = new java.lang.StringBuilder();
        sb_tDBOutput_1.append("INSERT INTO \"").append(tableName_tDBOutput_1).append("\" (\"version_id\",\"object_id\",\"vorname\",\"nachname\",\"gueltig_von\",\"gueltig_bis\") VALUES (?,?,?,?,?,?)");

        String insert_tDBOutput_1 = sb_tDBOutput_1.toString();
        
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing '")  + (insert_tDBOutput_1)  + ("'.") );
        
	    
	    java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
	    resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
	    

 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tUniqRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tUniqRow_1", false);
		start_Hash.put("tUniqRow_1", System.currentTimeMillis());
		
	
	currentComponent="tUniqRow_1";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row3");
			
		int tos_count_tUniqRow_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tUniqRow_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tUniqRow_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tUniqRow_1 = new StringBuilder();
                    log4jParamters_tUniqRow_1.append("Parameters:");
                            log4jParamters_tUniqRow_1.append("UNIQUE_KEY" + " = " + "[{CASE_SENSITIVE="+("false")+", KEY_ATTRIBUTE="+("false")+", SCHEMA_COLUMN="+("version_id")+"}, {CASE_SENSITIVE="+("false")+", KEY_ATTRIBUTE="+("true")+", SCHEMA_COLUMN="+("object_id")+"}, {CASE_SENSITIVE="+("false")+", KEY_ATTRIBUTE="+("false")+", SCHEMA_COLUMN="+("vorname")+"}, {CASE_SENSITIVE="+("false")+", KEY_ATTRIBUTE="+("false")+", SCHEMA_COLUMN="+("nachname")+"}, {CASE_SENSITIVE="+("false")+", KEY_ATTRIBUTE="+("false")+", SCHEMA_COLUMN="+("gueltig_von")+"}, {CASE_SENSITIVE="+("false")+", KEY_ATTRIBUTE="+("false")+", SCHEMA_COLUMN="+("gueltig_bis")+"}]");
                        log4jParamters_tUniqRow_1.append(" | ");
                            log4jParamters_tUniqRow_1.append("ONLY_ONCE_EACH_DUPLICATED_KEY" + " = " + "false");
                        log4jParamters_tUniqRow_1.append(" | ");
                            log4jParamters_tUniqRow_1.append("IS_VIRTUAL_COMPONENT" + " = " + "false");
                        log4jParamters_tUniqRow_1.append(" | ");
                            log4jParamters_tUniqRow_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "false");
                        log4jParamters_tUniqRow_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tUniqRow_1 - "  + (log4jParamters_tUniqRow_1) );
                    } 
                } 
            new BytesLimit65535_tUniqRow_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tUniqRow_1", "tUniqRow_1", "tUniqRow");
				talendJobLogProcess(globalMap);
			}
			

	
		class KeyStruct_tUniqRow_1 {
	
			private static final int DEFAULT_HASHCODE = 1;
		    private static final int PRIME = 31;
		    private int hashCode = DEFAULT_HASHCODE;
		    public boolean hashCodeDirty = true;
	
	        
					String object_id;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
								result = prime * result + ((this.object_id == null) ? 0 : this.object_id.hashCode());
								
		    		this.hashCode = result;
		    		this.hashCodeDirty = false;		
				}
				return this.hashCode;
			}
			
			@Override
			public boolean equals(Object obj) {
				if (this == obj) return true;
				if (obj == null) return false;
				if (getClass() != obj.getClass()) return false;
				final KeyStruct_tUniqRow_1 other = (KeyStruct_tUniqRow_1) obj;
				
									if (this.object_id == null) {
										if (other.object_id != null) 
											return false;
								
									} else if (!this.object_id.equals(other.object_id))
								 
										return false;
								
				
				return true;
			}
	  
	        
		}

	
int nb_uniques_tUniqRow_1 = 0;
int nb_duplicates_tUniqRow_1 = 0;
	log.debug("tUniqRow_1 - Start to process the data from datasource.");
KeyStruct_tUniqRow_1 finder_tUniqRow_1 = new KeyStruct_tUniqRow_1();
java.util.Set<KeyStruct_tUniqRow_1> keystUniqRow_1 = new java.util.HashSet<KeyStruct_tUniqRow_1>(); 

 



/**
 * [tUniqRow_1 begin ] stop
 */



	
	/**
	 * [tUnite_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tUnite_1", false);
		start_Hash.put("tUnite_1", System.currentTimeMillis());
		
	
	currentComponent="tUnite_1";
	
	
			runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,0,0,"row1","row2");
			
		int tos_count_tUnite_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tUnite_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tUnite_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tUnite_1 = new StringBuilder();
                    log4jParamters_tUnite_1.append("Parameters:");
                if(log.isDebugEnabled())
            log.debug("tUnite_1 - "  + (log4jParamters_tUnite_1) );
                    } 
                } 
            new BytesLimit65535_tUnite_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tUnite_1", "tUnite_1", "tUnite");
				talendJobLogProcess(globalMap);
			}
			

int nb_line_tUnite_1 = 0;

 



/**
 * [tUnite_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";
	
	
		int tos_count_tDBInput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
                    log4jParamters_tDBInput_1.append("Parameters:");
                            log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("CONNECTION" + " = " + "tDBConnection_1");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERY" + " = " + "\"SELECT    \\\"\"+context.demo_db_table_in_0+\"\\\".\\\"version_id\\\",    \\\"\"+context.demo_db_table_in_0+\"\\\".\\\"object_id\\\",    \\\"\"+context.demo_db_table_in_0+\"\\\".\\\"vorname\\\",    \\\"\"+context.demo_db_table_in_0+\"\\\".\\\"nachname\\\",    \\\"\"+context.demo_db_table_in_0+\"\\\".\\\"gueltig_von\\\",    \\\"\"+context.demo_db_table_in_0+\"\\\".\\\"gueltig_bis\\\" FROM \\\"\"+context.demo_db_table_in_0+\"\\\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USE_CURSOR" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("version_id")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("object_id")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("vorname")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("nachname")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("gueltig_von")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("gueltig_bis")+"}]");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlInput");
                        log4jParamters_tDBInput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + (log4jParamters_tDBInput_1) );
                    } 
                } 
            new BytesLimit65535_tDBInput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_1", "tDBInput_1", "tPostgresqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
    
	
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				conn_tDBInput_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				
				if(conn_tDBInput_1 != null) {
					if(conn_tDBInput_1.getMetaData() != null) {
						
							log.debug("tDBInput_1 - Uses an existing connection with username '" + conn_tDBInput_1.getMetaData().getUserName() + "'. Connection URL: " + conn_tDBInput_1.getMetaData().getURL() + ".");
						
					}
				}
			
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT \n  \""+context.demo_db_table_in_0+"\".\"version_id\", \n  \""+context.demo_db_table_in_0+"\".\"object_id\", \n  \""+context.demo_db_table_in_0+"\".\"vorname\", \n  \""+context.demo_db_table_in_0+"\".\"nachname\", \n  \""+context.demo_db_table_in_0+"\".\"gueltig_von\", \n  \""+context.demo_db_table_in_0+"\".\"gueltig_bis\"\nFROM \""+context.demo_db_table_in_0+"\"";
		    
	    		log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");
			

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    	log.debug("tDBInput_1 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.version_id = null;
							} else {
		                          
            row1.version_id = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    row1.version_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.object_id = null;
							} else {
	                         		
        	row1.object_id = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.vorname = null;
							} else {
	                         		
        	row1.vorname = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.nachname = null;
							} else {
	                         		
        	row1.nachname = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.gueltig_von = null;
							} else {
										
			row1.gueltig_von = routines.system.JDBCUtil.getDate(rs_tDBInput_1, 5);
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.gueltig_bis = null;
							} else {
										
			row1.gueltig_bis = routines.system.JDBCUtil.getDate(rs_tDBInput_1, 6);
		                    }
					
						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");
					


 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	
					if(runStat.update(execStat,enableLogStash,iterateId,1,1
						
							,"row1","tDBInput_1","tDBInput_1","tPostgresqlInput","tUnite_1","tUnite_1","tUnite"
							
					)) {
						talendJobLogProcess(globalMap);
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		
//////////
 

// for output
			row3 = new row3Struct();
								
			row3.version_id = row1.version_id;								
			row3.object_id = row1.object_id;								
			row3.vorname = row1.vorname;								
			row3.nachname = row1.nachname;								
			row3.gueltig_von = row1.gueltig_von;								
			row3.gueltig_bis = row1.gueltig_bis;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tUniqRow_1 main ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row3","tUnite_1","tUnite_1","tUnite","tUniqRow_1","tUniqRow_1","tUniqRow"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		
row4 = null;			
if(row3.object_id == null){
	finder_tUniqRow_1.object_id = null;
}else{
	finder_tUniqRow_1.object_id = row3.object_id.toLowerCase();
}	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
if(row3.object_id == null){
	new_tUniqRow_1.object_id = null;
}else{
	new_tUniqRow_1.object_id = row3.object_id.toLowerCase();
}
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row4 == null){ 
	
		log.trace("tUniqRow_1 - Writing the unique record " + (nb_uniques_tUniqRow_1+1) + " into row4.");
	
	row4 = new row4Struct();
}row4.version_id = row3.version_id;			row4.object_id = row3.object_id;			row4.vorname = row3.vorname;			row4.nachname = row3.nachname;			row4.gueltig_von = row3.gueltig_von;			row4.gueltig_bis = row3.gueltig_bis;					
		nb_uniques_tUniqRow_1++;
	} else {
	  nb_duplicates_tUniqRow_1++;
	}

 


	tos_count_tUniqRow_1++;

/**
 * [tUniqRow_1 main ] stop
 */
	
	/**
	 * [tUniqRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";
	
	

 



/**
 * [tUniqRow_1 process_data_begin ] stop
 */
// Start of branch "row4"
if(row4 != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row4","tUniqRow_1","tUniqRow_1","tUniqRow","tDBOutput_1","tDBOutput_1","tPostgresqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row4 - " + (row4==null? "": row4.toLogString()));
    			}
    		



        whetherReject_tDBOutput_1 = false;
                    if(row4.version_id == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(1, row4.version_id);
}

                    if(row4.object_id == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(2, row4.object_id);
}

                    if(row4.vorname == null) {
pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(3, row4.vorname);
}

                    if(row4.nachname == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(4, row4.nachname);
}

                    if(row4.gueltig_von != null) {
pstmt_tDBOutput_1.setTimestamp(5, new java.sql.Timestamp(row4.gueltig_von.getTime()));
} else {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.TIMESTAMP);
}

                    if(row4.gueltig_bis != null) {
pstmt_tDBOutput_1.setTimestamp(6, new java.sql.Timestamp(row4.gueltig_bis.getTime()));
} else {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.TIMESTAMP);
}

			
    		pstmt_tDBOutput_1.addBatch();
    		nb_line_tDBOutput_1++;
    		  
    		  
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Adding the record ")  + (nb_line_tDBOutput_1)  + (" to the ")  + ("INSERT")  + (" batch.") );
    		  batchSizeCounter_tDBOutput_1++;
    		  
            if(!whetherReject_tDBOutput_1) {
            }
    			if ((batchSize_tDBOutput_1 > 0) && (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
                try {
						int countSum_tDBOutput_1 = 0;
						    
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
				    	rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
				    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
            	    	batchSizeCounter_tDBOutput_1 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
				    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
				    	String errormessage_tDBOutput_1;
						if (ne_tDBOutput_1 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
							errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
						}else{
							errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
						}
				    	
				    		if (ne_tDBOutput_1 != null) {
				    			throw(sqle_tDBOutput_1);
				    		}else{
				            	throw(e_tDBOutput_1);
				            }
				    	
					}
    			}
    		

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "row4"




	
	/**
	 * [tUniqRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";
	
	

 



/**
 * [tUniqRow_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

 



/**
 * [tUnite_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
	    		log.debug("tDBInput_1 - Retrieved records count: "+nb_line_tDBInput_1 + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Done.") );

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */
	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";
	
	
		int tos_count_tDBInput_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
                    log4jParamters_tDBInput_2.append("Parameters:");
                            log4jParamters_tDBInput_2.append("USE_EXISTING_CONNECTION" + " = " + "true");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("CONNECTION" + " = " + "tDBConnection_1");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("QUERY" + " = " + "\"SELECT    \\\"\"+context.demo_db_table_in_1+\"\\\".\\\"version_id\\\",    \\\"\"+context.demo_db_table_in_1+\"\\\".\\\"object_id\\\",    \\\"\"+context.demo_db_table_in_1+\"\\\".\\\"vorname\\\",    \\\"\"+context.demo_db_table_in_1+\"\\\".\\\"nachname\\\",    \\\"\"+context.demo_db_table_in_1+\"\\\".\\\"gueltig_von\\\",    \\\"\"+context.demo_db_table_in_1+\"\\\".\\\"gueltig_bis\\\" FROM \\\"\"+context.demo_db_table_in_1+\"\\\"\"");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("USE_CURSOR" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("version_id")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("object_id")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("vorname")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("nachname")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("gueltig_von")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("gueltig_bis")+"}]");
                        log4jParamters_tDBInput_2.append(" | ");
                            log4jParamters_tDBInput_2.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlInput");
                        log4jParamters_tDBInput_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + (log4jParamters_tDBInput_2) );
                    } 
                } 
            new BytesLimit65535_tDBInput_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_2", "tDBInput_2", "tPostgresqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
    
	
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				conn_tDBInput_2 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
				
				if(conn_tDBInput_2 != null) {
					if(conn_tDBInput_2.getMetaData() != null) {
						
							log.debug("tDBInput_2 - Uses an existing connection with username '" + conn_tDBInput_2.getMetaData().getUserName() + "'. Connection URL: " + conn_tDBInput_2.getMetaData().getURL() + ".");
						
					}
				}
			
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT \n  \""+context.demo_db_table_in_1+"\".\"version_id\", \n  \""+context.demo_db_table_in_1+"\".\"object_id\", \n  \""+context.demo_db_table_in_1+"\".\"vorname\", \n  \""+context.demo_db_table_in_1+"\".\"nachname\", \n  \""+context.demo_db_table_in_1+"\".\"gueltig_von\", \n  \""+context.demo_db_table_in_1+"\".\"gueltig_bis\"\nFROM \""+context.demo_db_table_in_1+"\"";
		    
	    		log.debug("tDBInput_2 - Executing the query: '" + dbquery_tDBInput_2 + "'.");
			

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    	log.debug("tDBInput_2 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row2.version_id = null;
							} else {
		                          
            row2.version_id = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    row2.version_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row2.object_id = null;
							} else {
	                         		
        	row2.object_id = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row2.vorname = null;
							} else {
	                         		
        	row2.vorname = routines.system.JDBCUtil.getString(rs_tDBInput_2, 3, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row2.nachname = null;
							} else {
	                         		
        	row2.nachname = routines.system.JDBCUtil.getString(rs_tDBInput_2, 4, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row2.gueltig_von = null;
							} else {
										
			row2.gueltig_von = routines.system.JDBCUtil.getDate(rs_tDBInput_2, 5);
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row2.gueltig_bis = null;
							} else {
										
			row2.gueltig_bis = routines.system.JDBCUtil.getDate(rs_tDBInput_2, 6);
		                    }
					
						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");
					


 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	
					if(runStat.update(execStat,enableLogStash,iterateId,1,1
						
							,"row2","tDBInput_2","tDBInput_2","tPostgresqlInput","tUnite_1","tUnite_1","tUnite"
							
					)) {
						talendJobLogProcess(globalMap);
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		
//////////
 

// for output
			row3 = new row3Struct();
								
			row3.version_id = row2.version_id;								
			row3.object_id = row2.object_id;								
			row3.vorname = row2.vorname;								
			row3.nachname = row2.nachname;								
			row3.gueltig_von = row2.gueltig_von;								
			row3.gueltig_bis = row2.gueltig_bis;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tUniqRow_1 main ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row3","tUnite_1","tUnite_1","tUnite","tUniqRow_1","tUniqRow_1","tUniqRow"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		
row4 = null;			
if(row3.object_id == null){
	finder_tUniqRow_1.object_id = null;
}else{
	finder_tUniqRow_1.object_id = row3.object_id.toLowerCase();
}	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
if(row3.object_id == null){
	new_tUniqRow_1.object_id = null;
}else{
	new_tUniqRow_1.object_id = row3.object_id.toLowerCase();
}
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row4 == null){ 
	
		log.trace("tUniqRow_1 - Writing the unique record " + (nb_uniques_tUniqRow_1+1) + " into row4.");
	
	row4 = new row4Struct();
}row4.version_id = row3.version_id;			row4.object_id = row3.object_id;			row4.vorname = row3.vorname;			row4.nachname = row3.nachname;			row4.gueltig_von = row3.gueltig_von;			row4.gueltig_bis = row3.gueltig_bis;					
		nb_uniques_tUniqRow_1++;
	} else {
	  nb_duplicates_tUniqRow_1++;
	}

 


	tos_count_tUniqRow_1++;

/**
 * [tUniqRow_1 main ] stop
 */
	
	/**
	 * [tUniqRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";
	
	

 



/**
 * [tUniqRow_1 process_data_begin ] stop
 */
// Start of branch "row4"
if(row4 != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			if(runStat.update(execStat,enableLogStash,iterateId,1,1
				
					,"row4","tUniqRow_1","tUniqRow_1","tUniqRow","tDBOutput_1","tDBOutput_1","tPostgresqlOutput"
				
			)) {
				talendJobLogProcess(globalMap);
			}
			
    			if(log.isTraceEnabled()){
    				log.trace("row4 - " + (row4==null? "": row4.toLogString()));
    			}
    		



        whetherReject_tDBOutput_1 = false;
                    if(row4.version_id == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(1, row4.version_id);
}

                    if(row4.object_id == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(2, row4.object_id);
}

                    if(row4.vorname == null) {
pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(3, row4.vorname);
}

                    if(row4.nachname == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(4, row4.nachname);
}

                    if(row4.gueltig_von != null) {
pstmt_tDBOutput_1.setTimestamp(5, new java.sql.Timestamp(row4.gueltig_von.getTime()));
} else {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.TIMESTAMP);
}

                    if(row4.gueltig_bis != null) {
pstmt_tDBOutput_1.setTimestamp(6, new java.sql.Timestamp(row4.gueltig_bis.getTime()));
} else {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.TIMESTAMP);
}

			
    		pstmt_tDBOutput_1.addBatch();
    		nb_line_tDBOutput_1++;
    		  
    		  
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Adding the record ")  + (nb_line_tDBOutput_1)  + (" to the ")  + ("INSERT")  + (" batch.") );
    		  batchSizeCounter_tDBOutput_1++;
    		  
            if(!whetherReject_tDBOutput_1) {
            }
    			if ((batchSize_tDBOutput_1 > 0) && (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
                try {
						int countSum_tDBOutput_1 = 0;
						    
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
				    	rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
				    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
				    	
            	    	batchSizeCounter_tDBOutput_1 = 0;
                }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
				    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
				    	String errormessage_tDBOutput_1;
						if (ne_tDBOutput_1 != null) {
							// build new exception to provide the original cause
							sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
							errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
						}else{
							errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
						}
				    	
				    		if (ne_tDBOutput_1 != null) {
				    			throw(sqle_tDBOutput_1);
				    		}else{
				            	throw(e_tDBOutput_1);
				            }
				    	
					}
    			}
    		

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "row4"




	
	/**
	 * [tUniqRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";
	
	

 



/**
 * [tUniqRow_1 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

 



/**
 * [tUnite_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);
	    		log.debug("tDBInput_2 - Retrieved records count: "+nb_line_tDBInput_2 + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tDBInput_2 - "  + ("Done.") );

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */
	
	/**
	 * [tUnite_1 end ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

globalMap.put("tUnite_1_NB_LINE", nb_line_tUnite_1);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1","row2");
			  	}
			  	
				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"row1",2,0,
				 			"tDBInput_1","tDBInput_1","tPostgresqlInput","tUnite_1","tUnite_1","tUnite","output")) {
							talendJobLogProcess(globalMap);
						}
					
				 		if(runStat.log(resourceMap,iterateId,"row2",2,0,
				 			"tDBInput_2","tDBInput_2","tPostgresqlInput","tUnite_1","tUnite_1","tUnite","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tUnite_1 - "  + ("Done.") );

ok_Hash.put("tUnite_1", true);
end_Hash.put("tUnite_1", System.currentTimeMillis());




/**
 * [tUnite_1 end ] stop
 */

	
	/**
	 * [tUniqRow_1 end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";
	
	

globalMap.put("tUniqRow_1_NB_UNIQUES",nb_uniques_tUniqRow_1);
globalMap.put("tUniqRow_1_NB_DUPLICATES",nb_duplicates_tUniqRow_1);
	log.info("tUniqRow_1 - Unique records count: " + (nb_uniques_tUniqRow_1)+" .");
	log.info("tUniqRow_1 - Duplicate records count: " + (nb_duplicates_tUniqRow_1)+" .");

			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row3",2,0,
			 			"tUnite_1","tUnite_1","tUnite","tUniqRow_1","tUniqRow_1","tUniqRow","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tUniqRow_1 - "  + ("Done.") );

ok_Hash.put("tUniqRow_1", true);
end_Hash.put("tUniqRow_1", System.currentTimeMillis());




/**
 * [tUniqRow_1 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	



	    try {
				int countSum_tDBOutput_1 = 0;
				if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {
						
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
					for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
						
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
				}
		    	
		    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
		    	
	    }catch (java.sql.BatchUpdateException e_tDBOutput_1){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e_tDBOutput_1.getMessage());
	    	java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),sqle_tDBOutput_1=null;
	    	String errormessage_tDBOutput_1;
			if (ne_tDBOutput_1 != null) {
				// build new exception to provide the original cause
				sqle_tDBOutput_1 = new java.sql.SQLException(e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(), ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
				errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
			}else{
				errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
			}
	    	
	    		if (ne_tDBOutput_1 != null) {
	    			throw(sqle_tDBOutput_1);
	    		}else{
	            	throw(e_tDBOutput_1);
	            }
	    	
		}
	    
        if(pstmt_tDBOutput_1 != null) {
        		
            pstmt_tDBOutput_1.close();
            resourceMap.remove("pstmt_tDBOutput_1");
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	


			 		if(runStat.updateStatAndLog(execStat,enableLogStash,resourceMap,iterateId,"row4",2,0,
			 			"tUniqRow_1","tUniqRow_1","tUniqRow","tDBOutput_1","tDBOutput_1","tPostgresqlOutput","output")) {
						talendJobLogProcess(globalMap);
					}
				
 
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Done.") );

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk4", 0, "ok");
				}
				tDBCommit_1Process(globalMap);



/**
 * [tDBOutput_1 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	

 



/**
 * [tDBInput_1 finally ] stop
 */
	
	/**
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";
	
	

 



/**
 * [tDBInput_2 finally ] stop
 */
	
	/**
	 * [tUnite_1 finally ] start
	 */

	

	
	
	currentComponent="tUnite_1";
	
	

 



/**
 * [tUnite_1 finally ] stop
 */

	
	/**
	 * [tUniqRow_1 finally ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";
	
	

 



/**
 * [tUniqRow_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	



    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBCommit_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "tDBCommit_1");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBCommit_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBCommit_1", false);
		start_Hash.put("tDBCommit_1", System.currentTimeMillis());
		
	
	currentComponent="tDBCommit_1";
	
	
		int tos_count_tDBCommit_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBCommit_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBCommit_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBCommit_1 = new StringBuilder();
                    log4jParamters_tDBCommit_1.append("Parameters:");
                            log4jParamters_tDBCommit_1.append("CONNECTION" + " = " + "tDBConnection_1");
                        log4jParamters_tDBCommit_1.append(" | ");
                            log4jParamters_tDBCommit_1.append("CLOSE" + " = " + "true");
                        log4jParamters_tDBCommit_1.append(" | ");
                            log4jParamters_tDBCommit_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlCommit");
                        log4jParamters_tDBCommit_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBCommit_1 - "  + (log4jParamters_tDBCommit_1) );
                    } 
                } 
            new BytesLimit65535_tDBCommit_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBCommit_1", "tDBCommit_1", "tPostgresqlCommit");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tDBCommit_1 begin ] stop
 */
	
	/**
	 * [tDBCommit_1 main ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";
	
	

	java.sql.Connection conn_tDBCommit_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBCommit_1 != null && !conn_tDBCommit_1.isClosed())
	{
	
		try{
	
			
	    		log.debug("tDBCommit_1 - Connection 'tDBConnection_1' starting to commit.");
			
			conn_tDBCommit_1.commit();
			
	    		log.debug("tDBCommit_1 - Connection 'tDBConnection_1' commit has succeeded.");
			
	
		}finally{
			
	    		log.debug("tDBCommit_1 - Closing the connection 'tDBConnection_1' to the database.");
			
			conn_tDBCommit_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_tDBConnection_1"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBCommit_1 - Connection 'tDBConnection_1' to the database closed.");
			
	    }
	
	}

 


	tos_count_tDBCommit_1++;

/**
 * [tDBCommit_1 main ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";
	
	

 



/**
 * [tDBCommit_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";
	
	

 



/**
 * [tDBCommit_1 process_data_end ] stop
 */
	
	/**
	 * [tDBCommit_1 end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";
	
	

 
                if(log.isDebugEnabled())
            log.debug("tDBCommit_1 - "  + ("Done.") );

ok_Hash.put("tDBCommit_1", true);
end_Hash.put("tDBCommit_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk5", 0, "ok");
				}
				tJava_3Process(globalMap);



/**
 * [tDBCommit_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBCommit_1 finally ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";
	
	

 



/**
 * [tDBCommit_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "tJava_3");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tJava_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_3", false);
		start_Hash.put("tJava_3", System.currentTimeMillis());
		
	
	currentComponent="tJava_3";
	
	
		int tos_count_tJava_3 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tJava_3", "tJava_3", "tJava");
				talendJobLogProcess(globalMap);
			}
			


System.out.println("Table unique loaded.\n");
 



/**
 * [tJava_3 begin ] stop
 */
	
	/**
	 * [tJava_3 main ] start
	 */

	

	
	
	currentComponent="tJava_3";
	
	

 


	tos_count_tJava_3++;

/**
 * [tJava_3 main ] stop
 */
	
	/**
	 * [tJava_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_3";
	
	

 



/**
 * [tJava_3 process_data_begin ] stop
 */
	
	/**
	 * [tJava_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_3";
	
	

 



/**
 * [tJava_3 process_data_end ] stop
 */
	
	/**
	 * [tJava_3 end ] start
	 */

	

	
	
	currentComponent="tJava_3";
	
	

 

ok_Hash.put("tJava_3", true);
end_Hash.put("tJava_3", System.currentTimeMillis());




/**
 * [tJava_3 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_3 finally ] start
	 */

	

	
	
	currentComponent="tJava_3";
	
	

 



/**
 * [tJava_3 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_3_SUBPROCESS_STATE", 1);
	}
	

public void tDBRollback_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBRollback_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "tDBRollback_1");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBRollback_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBRollback_1", false);
		start_Hash.put("tDBRollback_1", System.currentTimeMillis());
		
	
	currentComponent="tDBRollback_1";
	
	
		int tos_count_tDBRollback_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBRollback_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBRollback_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBRollback_1 = new StringBuilder();
                    log4jParamters_tDBRollback_1.append("Parameters:");
                            log4jParamters_tDBRollback_1.append("CONNECTION" + " = " + "tDBConnection_1");
                        log4jParamters_tDBRollback_1.append(" | ");
                            log4jParamters_tDBRollback_1.append("CLOSE" + " = " + "true");
                        log4jParamters_tDBRollback_1.append(" | ");
                            log4jParamters_tDBRollback_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlRollback");
                        log4jParamters_tDBRollback_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBRollback_1 - "  + (log4jParamters_tDBRollback_1) );
                    } 
                } 
            new BytesLimit65535_tDBRollback_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBRollback_1", "tDBRollback_1", "tPostgresqlRollback");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tDBRollback_1 begin ] stop
 */
	
	/**
	 * [tDBRollback_1 main ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";
	
	

	java.sql.Connection conn_tDBRollback_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBRollback_1 != null && !conn_tDBRollback_1.isClosed()) {
		
			try{
				
	    		log.debug("tDBRollback_1 - Connection 'tDBConnection_1' starting to rollback.");
			
			conn_tDBRollback_1.rollback();
			
	    		log.debug("tDBRollback_1 - Connection 'tDBConnection_1' rollback has succeeded.");
			
			}finally{
		    	
	    		log.debug("tDBRollback_1 - Closing the connection 'tDBConnection_1' to the database.");
			
			conn_tDBRollback_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_tDBConnection_1"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBRollback_1 - Connection 'tDBConnection_1' to the database closed.");
			
		    }
		
	}

 


	tos_count_tDBRollback_1++;

/**
 * [tDBRollback_1 main ] stop
 */
	
	/**
	 * [tDBRollback_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";
	
	

 



/**
 * [tDBRollback_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBRollback_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";
	
	

 



/**
 * [tDBRollback_1 process_data_end ] stop
 */
	
	/**
	 * [tDBRollback_1 end ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";
	
	

 
                if(log.isDebugEnabled())
            log.debug("tDBRollback_1 - "  + ("Done.") );

ok_Hash.put("tDBRollback_1", true);
end_Hash.put("tDBRollback_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk6", 0, "ok");
				}
				tJava_4Process(globalMap);



/**
 * [tDBRollback_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBRollback_1 finally ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";
	
	

 



/**
 * [tDBRollback_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBRollback_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "tJava_4");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tJava_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_4", false);
		start_Hash.put("tJava_4", System.currentTimeMillis());
		
	
	currentComponent="tJava_4";
	
	
		int tos_count_tJava_4 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tJava_4", "tJava_4", "tJava");
				talendJobLogProcess(globalMap);
			}
			


System.out.println("Table unique could not be loaded.\n");
 



/**
 * [tJava_4 begin ] stop
 */
	
	/**
	 * [tJava_4 main ] start
	 */

	

	
	
	currentComponent="tJava_4";
	
	

 


	tos_count_tJava_4++;

/**
 * [tJava_4 main ] stop
 */
	
	/**
	 * [tJava_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_4";
	
	

 



/**
 * [tJava_4 process_data_begin ] stop
 */
	
	/**
	 * [tJava_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_4";
	
	

 



/**
 * [tJava_4 process_data_end ] stop
 */
	
	/**
	 * [tJava_4 end ] start
	 */

	

	
	
	currentComponent="tJava_4";
	
	

 

ok_Hash.put("tJava_4", true);
end_Hash.put("tJava_4", System.currentTimeMillis());




/**
 * [tJava_4 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_4 finally ] start
	 */

	

	
	
	currentComponent="tJava_4";
	
	

 



/**
 * [tJava_4 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_4_SUBPROCESS_STATE", 1);
	}
	

public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "tPostjob_1");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPostjob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPostjob_1", false);
		start_Hash.put("tPostjob_1", System.currentTimeMillis());
		
	
	currentComponent="tPostjob_1";
	
	
		int tos_count_tPostjob_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tPostjob_1", "tPostjob_1", "tPostjob");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tPostjob_1 begin ] stop
 */
	
	/**
	 * [tPostjob_1 main ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 


	tos_count_tPostjob_1++;

/**
 * [tPostjob_1 main ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 



/**
 * [tPostjob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 



/**
 * [tPostjob_1 process_data_end ] stop
 */
	
	/**
	 * [tPostjob_1 end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 

ok_Hash.put("tPostjob_1", true);
end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tDBClose_1Process(globalMap);



/**
 * [tPostjob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPostjob_1 finally ] start
	 */

	

	
	
	currentComponent="tPostjob_1";
	
	

 



/**
 * [tPostjob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBClose_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBClose_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "tDBClose_1");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBClose_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBClose_1", false);
		start_Hash.put("tDBClose_1", System.currentTimeMillis());
		
	
	currentComponent="tDBClose_1";
	
	
		int tos_count_tDBClose_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBClose_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBClose_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBClose_1 = new StringBuilder();
                    log4jParamters_tDBClose_1.append("Parameters:");
                            log4jParamters_tDBClose_1.append("CONNECTION" + " = " + "tDBConnection_1");
                        log4jParamters_tDBClose_1.append(" | ");
                            log4jParamters_tDBClose_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlClose");
                        log4jParamters_tDBClose_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBClose_1 - "  + (log4jParamters_tDBClose_1) );
                    } 
                } 
            new BytesLimit65535_tDBClose_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBClose_1", "tDBClose_1", "tPostgresqlClose");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tDBClose_1 begin ] stop
 */
	
	/**
	 * [tDBClose_1 main ] start
	 */

	

	
	
	currentComponent="tDBClose_1";
	
	



	java.sql.Connection conn_tDBClose_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");
	if(conn_tDBClose_1 != null && !conn_tDBClose_1.isClosed())
	{
                if(log.isDebugEnabled())
            log.debug("tDBClose_1 - "  + ("Closing the connection ")  + ("conn_tDBConnection_1")  + (" to the database.") );
        conn_tDBClose_1.close();
                if(log.isDebugEnabled())
            log.debug("tDBClose_1 - "  + ("Connection ")  + ("conn_tDBConnection_1")  + (" to the database has closed.") );
	}

 


	tos_count_tDBClose_1++;

/**
 * [tDBClose_1 main ] stop
 */
	
	/**
	 * [tDBClose_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBClose_1";
	
	

 



/**
 * [tDBClose_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBClose_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBClose_1";
	
	

 



/**
 * [tDBClose_1 process_data_end ] stop
 */
	
	/**
	 * [tDBClose_1 end ] start
	 */

	

	
	
	currentComponent="tDBClose_1";
	
	

 
                if(log.isDebugEnabled())
            log.debug("tDBClose_1 - "  + ("Done.") );

ok_Hash.put("tDBClose_1", true);
end_Hash.put("tDBClose_1", System.currentTimeMillis());




/**
 * [tDBClose_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBClose_1 finally ] start
	 */

	

	
	
	currentComponent="tDBClose_1";
	
	

 



/**
 * [tDBClose_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBClose_1_SUBPROCESS_STATE", 1);
	}
	

public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", TalendString.getAsciiRandomString(6));
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [talendJobLog begin ] start
	 */

	

	
		
		ok_Hash.put("talendJobLog", false);
		start_Hash.put("talendJobLog", System.currentTimeMillis());
		
	
	currentComponent="talendJobLog";
	
	
		int tos_count_talendJobLog = 0;
		

	for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
		org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
			.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid).custom("father_pid", fatherPid).custom("root_pid", rootPid);
		org.talend.logging.audit.Context log_context_talendJobLog = null;
		
		
		if(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
				.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)
				.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();
			auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
			auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
		
			log_context_talendJobLog = builder_talendJobLog
				.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
			auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();
			auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
			java.lang.Exception e_talendJobLog = jcm.exception;
			if(e_talendJobLog!=null) {
				try(java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
					e_talendJobLog.printStackTrace(pw_talendJobLog);
					builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
				}
			}

			if(jcm.extra_info!=null) {
				builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
			}
				
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
				.connectorId(jcm.component_id)
				.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label).build();

			auditLogger_talendJobLog.exception(log_context_talendJobLog);
		}
		
		
		
	}

 



/**
 * [talendJobLog begin ] stop
 */
	
	/**
	 * [talendJobLog main ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 


	tos_count_talendJobLog++;

/**
 * [talendJobLog main ] stop
 */
	
	/**
	 * [talendJobLog process_data_begin ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_begin ] stop
 */
	
	/**
	 * [talendJobLog process_data_end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_end ] stop
 */
	
	/**
	 * [talendJobLog end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 

ok_Hash.put("talendJobLog", true);
end_Hash.put("talendJobLog", System.currentTimeMillis());




/**
 * [talendJobLog end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [talendJobLog finally ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    
    
    private final static java.util.Properties jobInfo = new java.util.Properties();

    public static void main(String[] args){
        final demo_db_robot demo_db_robotClass = new demo_db_robot();

        int exitCode = demo_db_robotClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'demo_db_robot' - Done.");
	        }

        System.exit(exitCode);
    }
	

	
	
	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if(path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
			readJobInfo(new java.io.File(BUILD_PATH));
	}

    private void readJobInfo(java.io.File jobInfoFile){
	
        if(jobInfoFile.exists()) {
            try {
            	jobInfo.load(new java.io.FileInputStream(jobInfoFile));
            } catch (IOException e) {
            	 
                log.debug("Read jobInfo.properties file fail: " + e.getMessage());
                
            }
        }
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s",
				projectName,jobName,jobInfo.getProperty("gitCommitId"), "8.0.1.20220923_1236-patch"));
		
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

	        if(!"".equals(log4jLevel)){
	        	
				
				
				if("trace".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.OFF);
				}
				org.apache.logging.log4j.core.config.Configurator.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());
				
			}

	        getjobInfo();
			log.info("TalendJob: 'demo_db_robot' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_3T3h8CRPEe2AouJ5Ky595w");
                org.slf4j.MDC.put("_compiledAtTimestamp","2022-10-26T12:30:05.480550800Z");

                java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
                String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
                if (mxNameTable.length == 2) {
                    org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
                } else {
                    org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
                }

		
		
			if(enableLogStash) {
				java.util.Properties properties_talendJobLog = new java.util.Properties();
				properties_talendJobLog.setProperty("root.logger", "audit");
				properties_talendJobLog.setProperty("encoding", "UTF-8");
				properties_talendJobLog.setProperty("application.name", "Talend Studio");
				properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
				properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
				properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
				properties_talendJobLog.setProperty("log.appender", "file");
				properties_talendJobLog.setProperty("appender.file.path", "audit.json");
				properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
				properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
				properties_talendJobLog.setProperty("host", "false");

				System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()), System.getProperty(key)));

				
				
				
				org.apache.logging.log4j.core.config.Configurator.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);
				
				auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory.createJobAuditLogger(properties_talendJobLog);
			}
		

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

            org.slf4j.MDC.put("_pid", pid);

        if (rootPid==null) {
            rootPid = pid;
        }

            org.slf4j.MDC.put("_rootPid", rootPid);

        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }
            org.slf4j.MDC.put("_fatherPid", fatherPid);

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        try {
            java.util.Dictionary<String, Object> jobProperties = null;
            if (inOSGi) {
                jobProperties = routines.system.BundleUtils.getJobProperties(jobName);
    
                if (jobProperties != null && jobProperties.get("context") != null) {
                    contextStr = (String)jobProperties.get("context");
                }
            }
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = demo_db_robot.class.getClassLoader().getResourceAsStream("ashowcaserobotframework/demo_db_robot_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = demo_db_robot.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
    	                defaultProps.load(inContext);
    	                if (inOSGi && jobProperties != null) {
                             java.util.Enumeration<String> keys = jobProperties.keys();
                             while (keys.hasMoreElements()) {
                                 String propKey = keys.nextElement();
                                 if (defaultProps.containsKey(propKey)) {
                                     defaultProps.put(propKey, (String) jobProperties.get(propKey));
                                 }
                             }
    	                }
    	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("demo_db_postgres_Server", "id_String");
                        if(context.getStringValue("demo_db_postgres_Server") == null) {
                            context.demo_db_postgres_Server = null;
                        } else {
                            context.demo_db_postgres_Server=(String) context.getProperty("demo_db_postgres_Server");
                        }
                        context.setContextType("demo_db_postgres_Database", "id_String");
                        if(context.getStringValue("demo_db_postgres_Database") == null) {
                            context.demo_db_postgres_Database = null;
                        } else {
                            context.demo_db_postgres_Database=(String) context.getProperty("demo_db_postgres_Database");
                        }
                        context.setContextType("demo_db_postgres_Login", "id_String");
                        if(context.getStringValue("demo_db_postgres_Login") == null) {
                            context.demo_db_postgres_Login = null;
                        } else {
                            context.demo_db_postgres_Login=(String) context.getProperty("demo_db_postgres_Login");
                        }
                        context.setContextType("demo_db_postgres_Password", "id_Password");
                        if(context.getStringValue("demo_db_postgres_Password") == null) {
                            context.demo_db_postgres_Password = null;
                        } else {
                            String pwd_demo_db_postgres_Password_value = context.getProperty("demo_db_postgres_Password");
                            context.demo_db_postgres_Password = null;
                            if(pwd_demo_db_postgres_Password_value!=null) {
                                if(context_param.containsKey("demo_db_postgres_Password")) {//no need to decrypt if it come from program argument or parent job runtime
                                    context.demo_db_postgres_Password = pwd_demo_db_postgres_Password_value;
                                } else if (!pwd_demo_db_postgres_Password_value.isEmpty()) {
                                    try {
                                        context.demo_db_postgres_Password = routines.system.PasswordEncryptUtil.decryptPassword(pwd_demo_db_postgres_Password_value);
                                        context.put("demo_db_postgres_Password",context.demo_db_postgres_Password);
                                    } catch (java.lang.RuntimeException e) {
                                        //do nothing
                                    }
                                }
                            }
                        }
                        context.setContextType("demo_db_postgres_Port", "id_String");
                        if(context.getStringValue("demo_db_postgres_Port") == null) {
                            context.demo_db_postgres_Port = null;
                        } else {
                            context.demo_db_postgres_Port=(String) context.getProperty("demo_db_postgres_Port");
                        }
                        context.setContextType("demo_db_postgres_AdditionalParams", "id_String");
                        if(context.getStringValue("demo_db_postgres_AdditionalParams") == null) {
                            context.demo_db_postgres_AdditionalParams = null;
                        } else {
                            context.demo_db_postgres_AdditionalParams=(String) context.getProperty("demo_db_postgres_AdditionalParams");
                        }
                        context.setContextType("demo_db_postgres_Schema", "id_String");
                        if(context.getStringValue("demo_db_postgres_Schema") == null) {
                            context.demo_db_postgres_Schema = null;
                        } else {
                            context.demo_db_postgres_Schema=(String) context.getProperty("demo_db_postgres_Schema");
                        }
                        context.setContextType("demo_db_table_in_0", "id_String");
                        if(context.getStringValue("demo_db_table_in_0") == null) {
                            context.demo_db_table_in_0 = null;
                        } else {
                            context.demo_db_table_in_0=(String) context.getProperty("demo_db_table_in_0");
                        }
                        context.setContextType("demo_db_table_in_1", "id_String");
                        if(context.getStringValue("demo_db_table_in_1") == null) {
                            context.demo_db_table_in_1 = null;
                        } else {
                            context.demo_db_table_in_1=(String) context.getProperty("demo_db_table_in_1");
                        }
                        context.setContextType("demo_db_table_out_0", "id_String");
                        if(context.getStringValue("demo_db_table_out_0") == null) {
                            context.demo_db_table_out_0 = null;
                        } else {
                            context.demo_db_table_out_0=(String) context.getProperty("demo_db_table_out_0");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("demo_db_postgres_Server")) {
                context.demo_db_postgres_Server = (String) parentContextMap.get("demo_db_postgres_Server");
            }if (parentContextMap.containsKey("demo_db_postgres_Database")) {
                context.demo_db_postgres_Database = (String) parentContextMap.get("demo_db_postgres_Database");
            }if (parentContextMap.containsKey("demo_db_postgres_Login")) {
                context.demo_db_postgres_Login = (String) parentContextMap.get("demo_db_postgres_Login");
            }if (parentContextMap.containsKey("demo_db_postgres_Password")) {
                context.demo_db_postgres_Password = (java.lang.String) parentContextMap.get("demo_db_postgres_Password");
            }if (parentContextMap.containsKey("demo_db_postgres_Port")) {
                context.demo_db_postgres_Port = (String) parentContextMap.get("demo_db_postgres_Port");
            }if (parentContextMap.containsKey("demo_db_postgres_AdditionalParams")) {
                context.demo_db_postgres_AdditionalParams = (String) parentContextMap.get("demo_db_postgres_AdditionalParams");
            }if (parentContextMap.containsKey("demo_db_postgres_Schema")) {
                context.demo_db_postgres_Schema = (String) parentContextMap.get("demo_db_postgres_Schema");
            }if (parentContextMap.containsKey("demo_db_table_in_0")) {
                context.demo_db_table_in_0 = (String) parentContextMap.get("demo_db_table_in_0");
            }if (parentContextMap.containsKey("demo_db_table_in_1")) {
                context.demo_db_table_in_1 = (String) parentContextMap.get("demo_db_table_in_1");
            }if (parentContextMap.containsKey("demo_db_table_out_0")) {
                context.demo_db_table_out_0 = (String) parentContextMap.get("demo_db_table_out_0");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
			parametersToEncrypt.add("demo_db_postgres_Password");
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,ContextProperties.class,parametersToEncrypt));

            org.slf4j.MDC.put("_context", contextStr);
            log.info("TalendJob: 'demo_db_robot' - Started.");

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob

try {
errorCode = null;tPrejob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPrejob_1) {
globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

e_tPrejob_1.printStackTrace();

}



		if(enableLogStash) {
	        talendJobLog.addJobStartMessage();
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

e_tDBInput_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob

try {
errorCode = null;tPostjob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPostjob_1) {
globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

e_tPostjob_1.printStackTrace();

}



        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : demo_db_robot");
        }
		if(enableLogStash) {
	        talendJobLog.addJobEndMessage(startTime, end, status);
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");
    resumeUtil.flush();


        org.slf4j.MDC.remove("_subJobName");
        org.slf4j.MDC.remove("_subJobPid");
        org.slf4j.MDC.remove("_systemPid");
        log.info("TalendJob: 'demo_db_robot' - Finished - status: " + status + " returnCode: " + returnCode );

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {
    closeSqlDbConnections();


    }



    private void closeSqlDbConnections() {
        try {
            Object obj_conn;
            obj_conn = globalMap.remove("conn_tDBConnection_1");
            if (null != obj_conn) {
                ((java.sql.Connection) obj_conn).close();
            }
        } catch (java.lang.Exception e) {
        }
    }











    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
            connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     212159 characters generated by Talend Cloud Data Fabric 
 *     on the 26. Oktober 2022 um 14:30:05 MESZ
 ************************************************************************************************/