/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.impl.optimize;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.history.HistoricActivityInstance;
import org.camunda.bpm.engine.impl.persistence.AbstractManager;

public class OptimizeManager extends AbstractManager {

  @SuppressWarnings("unchecked")
  public List<HistoricActivityInstance> getHistoricActivityInstances(Date finishedAfter, int maxResults) {

    // TODO:
    // 1- authorization check
    // 2- if maxResults <= 0 => maxResults = Integer.MAX_VALUE (?)

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("finishedAfter", finishedAfter);
    params.put("maxResults", maxResults);

    return getDbEntityManager().selectList("selectHistoricActivityPage", params);
  }
  
}
