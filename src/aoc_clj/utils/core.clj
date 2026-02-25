(ns aoc-clj.utils.core
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn- read-input-lines
  [year day]
  (let [path (format "inputs/%d/day%02d.txt" (long year) (long day))
        file (io/file path)
        raw  (if (.exists ^java.io.File file)
               (slurp file)
               (throw (ex-info (format "Could not find puzzle input for %d day %02d" year day)
                               {:year year
                                :day day
                                :checked-file (.getPath ^java.io.File file)})))]
    (vec (str/split-lines raw))))

(defn parse-puzzle-input
  "Reads puzzle input for a year/day pair, splits into raw lines, and passes
   the lines to `parse-fn`."
  [parse-fn year day]
  (parse-fn (read-input-lines year day)))
