/*
 * Copyright 2016 - 2017, Acciente LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hr.framework.config.security.oacc.conf.starter.auth;

import com.acciente.oacc.AccessControlContext;

import java.security.Principal;

public interface OaccPrincipal extends Principal {
   AccessControlContext getAccessControlContext();
}
