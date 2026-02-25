(ns aoc-clj.2025.day01
  (:require [aoc-clj.utils.core :as u]
            [clojure.string :as str]))

;; Input parsing
(defn parse-line
  [line]
  (let [num (read-string (subs line 1))]
    (if (str/starts-with? line "L")
      (- num)
      num)))

(defn parse
  [input]
  (map parse-line input))

;; constant for the puzzle
(def init-pos 50)
(def dial-size 100)

;; example data
(def example
  ["L68"
   "L30"
   "R48"
   "L5"
   "R60"
   "L55"
   "L1"
   "L99"
   "R14"
   "L82"])

(def raw-input (u/parse-puzzle-input parse 2025 1))

(defn normalizer [a]
  (if (< a dial-size)
    a
    (normalizer (- a dial-size))))

(defn accumulator [a b]
  (let [sum (+ a b)]
    (cond
      (>= sum dial-size) (- sum dial-size)
      (< sum 0) (+ dial-size sum)
      :else sum)))

(comment
  (accumulator 50 -68)
  (reductions accumulator init-pos (map parse-action example))
  (normalizer 500)
  (mod 500 dial-size)
  (map normalizer raw-input)
  (part1 raw-input)
  )

(defn part1
  [input]
  (count (filter zero? (reductions accumulator init-pos (map #(mod % dial-size) input)))))

;; ### Solution online via https://github.com/klsmithphd/aoc-clj/blob/main/src/aoc_clj/2025/day01.clj
(defn dial-positions
  "A collection of all of the dial positions after applying each turn"
  [turns]
  (reductions (partial #(mod (+' %2 %3) %1) dial-size) init-pos turns))

(defn zero-count
  "A count of all of the times that the dial was at position 0"
  [turns]
  (count (filter zero? (dial-positions turns))))

(defn turn->clicks
  "Converts a turn into a sequence of the individual click movements, i.e.,
   a sequence of 1 or -1, repeated `turn` times"
  [turn]
  (if (neg? turn)
    (repeat (- turn) -1)
    (repeat turn 1)))

(defn clicks
  "Converts all the provided turns into a sequence of individual click movements
   (i.e. turns with distance 1)"
  [turns]
  (mapcat turn->clicks turns))

(defn zero-click-count
  "A count of all the times the dial ever passed the zero position"
  [turns]
  (zero-count (clicks turns)))

;; Puzzle solutions
(defn part1
  "What's the actual password to open the door?"
  [input]
  (zero-count input))

(defn part2
  "Using password method 0x434C49434B, what is the password to open the door?"
  [input]
  (zero-click-count input))

(comment
  (dial-positions raw-input)
  (part1 raw-input)
  (part2 raw-input))
