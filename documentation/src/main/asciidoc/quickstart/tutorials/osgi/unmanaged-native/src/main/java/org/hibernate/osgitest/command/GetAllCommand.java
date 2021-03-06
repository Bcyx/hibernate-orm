/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hibernate.osgitest.command;

import java.util.List;

import org.apache.felix.gogo.commands.Action;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.service.command.CommandSession;
import org.hibernate.osgitest.DataPointService;
import org.hibernate.osgitest.entity.DataPoint;

@Command(scope = "dp", name = "getAll")
public class GetAllCommand implements Action {
    private DataPointService dpService;
    
    public void setDpService(DataPointService dpService) {
        this.dpService = dpService;
    }

    public Object execute(CommandSession session) throws Exception {
        List<DataPoint> dps = dpService.getAll();
        for (DataPoint dp : dps) {
            System.out.println(dp.getId() + ", " + dp.getName());
        }
        return null;
    }

}
