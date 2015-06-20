package ro.dezertatie.web;

import ro.dezertatie.common.security.Authenticated;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Authenticated
@ApplicationPath("/api")
public class DisertatieApp extends Application {
}
