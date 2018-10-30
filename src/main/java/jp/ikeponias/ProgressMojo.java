package jp.ikeponias;

import java.util.concurrent.TimeUnit;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "progress")
public class ProgressMojo extends AbstractMojo {
	public void execute() throws MojoExecutionException {
		for (int i = 0; i <= 100; i++) {
			System.out.print(String.format("\r["));
			for (int j = 0; j < 10; j++) {
				System.out.print(String.format(j < i / 10 ? "*" : "-"));
			}
			System.out.print(String.format("] %d %%", i));
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}