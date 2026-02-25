(defproject aoc-clj "0.1.0-SNAPSHOT"
  :description "Advent of Code solutions in Clojure"
  :url "https://example.com/aoc-clj"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [clojure.java-time/clojure.java-time "1.1.0"]
                 [io.github.nextjournal/clerk "0.15.957"]
                 [org.clojure/core.match "1.0.1"]]
  :source-paths ["src"]
  :aliases {"clerk-serve" ["run" "-m" "aoc-clj.clerk" "serve"]
            "clerk-build" ["run" "-m" "aoc-clj.clerk" "build"]}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
