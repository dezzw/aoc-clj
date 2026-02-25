(defproject aoc-clj "0.1.0-SNAPSHOT"
  :description "Advent of Code solutions in Clojure"
  :url "https://dezzw.github.io/aoc-clj"
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [clojure.java-time/clojure.java-time "1.1.0"]
                 [io.github.nextjournal/clerk "0.15.957"]
                 [org.clojure/core.match "1.0.1"]]
  :source-paths ["src"]
  :aliases {"clerk-serve" ["run" "-m" "aoc-clj.clerk" "serve"]
            "clerk-build" ["run" "-m" "aoc-clj.clerk" "build"]}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
