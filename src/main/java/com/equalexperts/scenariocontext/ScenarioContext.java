package com.equalexperts.scenariocontext;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

  private Map<String, Object> dictionary;

  public ScenarioContext() {
    this.dictionary = new HashMap<String, Object>();
  }

  public void set(String key, Object value) {
    this.dictionary.put(key, value);
  }

  public Object get(String key) {
    return this.dictionary.get(key);
  }
}
