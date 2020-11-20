package ser531.team7;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ontology {

	private static final String PROPERTIES_FILE_NAME = "app.properties";
	private Logger log;
	private Properties properties;

	public Ontology() {
		log = LogManager.getLogger(this);
		properties = new Properties();
		readProperties();
	}

	public static void main(String[] args) {
		Ontology ontology = new Ontology();
//		ontology.readAllJobs();
//		ontology.readAllCompanies();
//		ontology.readAllLocations();
		ontology.locationBasedSearch();
	}

	private void readProperties() {
		InputStream inputStream = null;
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException(
						"Property file '" + PROPERTIES_FILE_NAME + "' not found in the classpath");
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
					log.error(e);
				}
			}
		}
	}

	public void readAllJobs() {
		QueryExecution qe = null;
		Query query = null;

		try {
			query = QueryFactory.create(SparqlQuery.QUERY_READ_ALL_JOBS);

			qe = QueryExecutionFactory.sparqlService(properties.getProperty("server1.url"), query);

			ResultSet results = qe.execSelect();

			while (results.hasNext()) {
				QuerySolution row = results.next();
				String subject = row.get("subject") != null ? row.get("subject").toString() : "NULL";
				String predicate = row.get("predicate") != null ? row.get("predicate").toString() : "NULL";
				String object = row.get("object") != null ? row.get("object").toString() : "NULL";
				log.info("-------------------------------------");
				log.info(subject);
				log.info(predicate);
				log.info(object);
				log.info("-------------------------------------");
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (qe != null) {
				qe.close();
			}
		}
	}

	public void readAllCompanies() {
		QueryExecution qe = null;
		Query query = null;

		try {
			query = QueryFactory.create(SparqlQuery.QUERY_READ_ALL_JOBS);

			qe = QueryExecutionFactory.sparqlService(properties.getProperty("server2.url"), query);

			ResultSet results = qe.execSelect();

			while (results.hasNext()) {
				QuerySolution row = results.next();
				String subject = row.get("subject") != null ? row.get("subject").toString() : "NULL";
				String predicate = row.get("predicate") != null ? row.get("predicate").toString() : "NULL";
				String object = row.get("object") != null ? row.get("object").toString() : "NULL";
				log.info("-------------------------------------");
				log.info(subject);
				log.info(predicate);
				log.info(object);
				log.info("-------------------------------------");
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (qe != null) {
				qe.close();
			}
		}
	}

	public void readAllLocations() {
		QueryExecution qe = null;
		Query query = null;

		try {
			query = QueryFactory.create(SparqlQuery.QUERY_READ_ALL_JOBS);

			qe = QueryExecutionFactory.sparqlService(properties.getProperty("server3.url"), query);

			ResultSet results = qe.execSelect();

			while (results.hasNext()) {
				QuerySolution row = results.next();
				String subject = row.get("subject") != null ? row.get("subject").toString() : "NULL";
				String predicate = row.get("predicate") != null ? row.get("predicate").toString() : "NULL";
				String object = row.get("object") != null ? row.get("object").toString() : "NULL";
				log.info("-------------------------------------");
				log.info(subject);
				log.info(predicate);
				log.info(object);
				log.info("-------------------------------------");
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (qe != null) {
				qe.close();
			}
		}
	}
	
	public void locationBasedSearch() {
		QueryExecution qe = null;
		Query query = null;

		try {
			query = QueryFactory.create(SparqlQuery.LOCATION_BASED_SEARCH);

			qe = QueryExecutionFactory.sparqlService(properties.getProperty("server3.url"), query);

			ResultSet results = qe.execSelect();

			while (results.hasNext()) {
				QuerySolution row = results.next();
				String subject = row.get("company_name") != null ? row.get("company_name").toString() : "NULL";
				String predicate = row.get("city_name") != null ? row.get("city_name").toString() : "NULL";
				String title = row.get("job_title") != null ? row.get("job_title").toString() : "NULL";
				String date = row.get("date") != null ? row.get("date").toString() : "NULL";
				log.info("-------------------------------------");
				log.info(subject);
				log.info(predicate);
				log.info(title);
				log.info(date);
				log.info("-------------------------------------");
			}
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (qe != null) {
				qe.close();
			}
		}
	}
}
