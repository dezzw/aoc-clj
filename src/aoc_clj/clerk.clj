(ns aoc-clj.clerk
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [nextjournal.clerk :as clerk]))

(defn- day-file?
  [^java.io.File f]
  (and (.isFile f)
       (re-find #"src/aoc_clj/\d{4}/day\d{2}\.clj$" (.getPath f))))

(defn day-paths
  []
  (->> (file-seq (io/file "src/aoc_clj"))
       (filter day-file?)
       (map #(.getPath ^java.io.File %))
       (map #(str/replace % #"^\./" ""))
       sort
       vec))

(defn serve!
  []
  (clerk/serve! {:watch-paths ["src"]}))

(defn build!
  []
  (let [paths (day-paths)
        opts  (cond-> {:paths paths}
                (seq paths) (assoc :index (first paths)))]
    (clerk/build! opts)))

(defn -main
  [& args]
  (case (first args)
    "build" (build!)
    (serve!)))
