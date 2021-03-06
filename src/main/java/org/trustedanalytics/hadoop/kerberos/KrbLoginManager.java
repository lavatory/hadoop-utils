/**
 * Copyright (c) 2015 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.trustedanalytics.hadoop.kerberos;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;
import org.trustedanalytics.hadoop.config.client.oauth.JwtToken;

import sun.security.krb5.KrbException;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import java.io.IOException;

public interface KrbLoginManager {

  Subject loginWithJWTtoken(JwtToken jwtToken) throws LoginException;

  Subject loginWithCredentials(String user, char[] password) throws LoginException;

  Subject loginWithKeyTab(String user, String path) throws LoginException, KrbException;

  void loginInHadoop(Subject subject, Configuration hadoopConf) throws IOException;

  UserGroupInformation getUGI(Subject subject) throws IOException;

}
