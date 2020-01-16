package com.project.workshopmanagment.security;

import java.math.BigInteger;

public class SecurityConstants {
    public static final String SECRET_KEY = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 3600000;
    public static final BigInteger EXPIRATION_TIME_REMEMBERME= new BigInteger("7776000000");
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
    public static final String SIGN_IN_URL = "/users/login";
}