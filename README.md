# Versionator

This is a fork of (or based on if you prefer) the lein-git-version
plugin available here https://github.com/cvillecsteele/lein-git-version/

## Description

`versionator` is a lein plugin that generates a version number for
your Clojure project.

We also write a file with the _version_ and the _ref_ to a Clojure
file.  The _version_ is the version number of the project, and the
_ref_ is a reference to the underlying fully qualified version.  By
default we use `git describe` for the version number and the git sha1
for the ref, but that can be changed.

By default we write the file as `packagename/versionator.clj`

## Usage

Add

    [ctdean/versionator "0.9.0"]

to your plugins vector.  For example:

    :plugins [[ctdean/versionator "0.9.0"]]

You can use `lein versionator` to print out the version and ref.

If you use the default settings, you'll need to create an annotated
`git tag` for `git describe` to use when it finds the version:

    git tag -a -m "Version 1.0" v1.0
    git push --tags

## Configuration

`versionator` can be configured by setting the `:versionator` property
in `project.clj`

Here are the defaults (these all may be overriden):

```clojure
:versionator
  {:version {:command ["git" "describe" "--long" "--match" "v*.*" "--dirty=-**DIRTY**"]
             :match #"^\s*v(\S+)-(\S+)-(g\S+)\s*"
             :replacement "$1.$2-$3"}
   :ref {:command ["git" "rev-parse" "--verify" "HEAD"]
         :match #"\s+"
         :replacement ""}}
```

Contact me with configuration questions.

## Authors

- Chris Dean <ctdean@sokitomi.com>
- Based Colin Steele's original code

## License

Copyright © 2012 Colin Steele
Copyright © 201r Chris Dean

Distributed under the Eclipse Public License, the same as Clojure.
