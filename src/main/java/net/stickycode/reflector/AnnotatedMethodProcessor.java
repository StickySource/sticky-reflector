/**
 * Copyright (c) 2010 RedEngine Ltd, http://www.redengine.co.nz. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package net.stickycode.reflector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

public abstract class AnnotatedMethodProcessor
    implements MethodProcessor {

  private Class<? extends Annotation>[] annotation;

  @SafeVarargs
  public AnnotatedMethodProcessor(Class<? extends Annotation>... annotation) {
    this.annotation = annotation;
  }

  @Override
  public boolean canProcess(Method method) {
    for (Class<? extends Annotation> a : annotation)
      if (method.isAnnotationPresent(a))
        return true;

    return false;
  }

  @Override
  public void sort(List<Method> methods) {
  }

}
