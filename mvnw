#!/bin/sh
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.

# Unix Maven Wrapper

basedir=$(cd "$(dirname "$0")" && pwd) || exit
maven_home="${M2_HOME}"

if [ -z "$maven_home" ]; then
  maven_home="$basedir/.mvn/wrapper/maven-3.9.6"
fi

maven_bin="$maven_home/bin/mvn"

if [ ! -f "$maven_bin" ]; then
  echo "Downloading Maven 3.9.6..."
  mkdir -p "$maven_home"
  curl -fsSL "https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz" | tar xzf - -C "$maven_home" --strip-components=1
fi

"$maven_bin" "$@"
