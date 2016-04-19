(ns leiningen.versionator
  (:require
   [clojure.java.shell :refer [sh]]
   clojure.string))

(def default
  {:version {:command ["git" "describe" "--long" "--match" "v*.*" "--dirty=-**DIRTY**"]
             :match #"^\s*v(\S+)-(\S+)-(g\S+)\s*"
             :replacement "$1.$2-$3"}
   :ref {:command ["git" "rev-parse" "--verify" "HEAD"]
         :match #"\s+"
         :replacement ""}})

(defn- merged [project]
  (let [base (:versionator project)]
    {:version (merge (:version default) (:version base))
     :ref (merge (:ref default) (:ref base))}))

(defn current-version [project]
  (let [conf (:version (merged project))
        res (:out (apply sh (:command conf)))]
    (clojure.string/replace res (:match conf) (:replacement conf))))

(defn current-ref [project]
  (let [conf (:ref (merged project))
        res (:out (apply sh (:command conf)))]
    (clojure.string/replace res (:match conf) (:replacement conf))))

(def get-version (memoize current-version))
(def get-ref (memoize current-ref))

(defn versionator
  "Show generated project version."
  ^{:doc "Show generated project version"}
  [project & args]
  (println (get-version project))
  (println (get-ref project)))
