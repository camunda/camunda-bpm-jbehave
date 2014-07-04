package org.camunda.bpm.data;

import java.io.Serializable;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

/**
 * Activity guard base. <br />
 * Is intended to be used as a base class for pre- and post-condition guard on
 * regular activities. This class is intended to be subclassed and the subclass
 * should be registered as an execution listener for start and end events on the
 * activity.
 * 
 * @author Simon Zambrovski, holisticon AG.
 * 
 */
public abstract class ActivityGuard implements ExecutionListener, Serializable, Guard {
  private static final long serialVersionUID = 1L;

  public void checkPostconditions(final DelegateExecution execution) throws IllegalStateException {
  }

  public void checkPreconditions(final DelegateExecution execution) throws IllegalStateException {
  }

  public void notify(DelegateExecution delegateExecution) throws Exception {
    Guards.dispatch(this, delegateExecution.getEventName(), delegateExecution);
  }
}
