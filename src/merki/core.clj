(ns merki.core
  (:require
   [clojure.string :as string]
   [clj-sub-command.core :refer [parse-cmds]]
   [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(defn error-msg [errors]
  (str "The following errors occurred while parsing your command:\n\n"
       (string/join \newline errors)))

(defn exit [status msg]
  (println msg)
  (System/exit status))

(def options
  [["-h" "--help"]])

(def commands
  [["add" "Add new measurement"]])

(defn usage [options-summary commands-summary]
  (->> ["Usage: program-name [--help] <command> [<args>]"
        ""
        "Options:"
        options-summary
        ""
        "Commands:"
        commands-summary]
       (string/join \newline)))

(defn add [args]
  (println args))

(defn -main [& args]
  (let [{:keys [options command arguments errors options-summary commands-summary]}
        (parse-cmds args options commands)]
    (cond
      (:help options) (exit 0 (usage options-summary commands-summary))
      errors (exit 1 (error-msg errors)))
    (case command
      :add (add arguments))))
