# Versionator

This is a fork of (or based on if you prefer) the lein-git-version
plugin available here https://github.com/cvillecsteele/lein-git-version/

## Description

`versionator` is a lein plugin that generates a version number for
your Clojure project.  By default it creates version numbers that look
like `0.5.54-g8081349`

We also write the _version_ to a Clojure file.  The _version_ is the
version number of the project.  By default we use `git describe` for
the version number but that can be changed.

By default we write the file as `packagename/versionator.clj`

## Usage

Add

    [ctdean/versionator "0.9.0"]

to your plugins vector.  For example:

    :plugins [[ctdean/versionator "0.9.0"]]

You can use `lein versionator` to print out the version.

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
             :replacement "$1.$2-$3"}}
```

Contact me with configuration questions.

## Authors

- Chris Dean <ctdean@sokitomi.com>
- Based Colin Steele's original code

## License

- Copyright © 2012 Colin Steele
- Copyright © 2016 Chris Dean

Distributed under the Eclipse Public License, the same as Clojure.


1.   No net new FTE, assume all contractor for now, if we later want to convert contractors to FTE we can do that, depending on the status of the work
2.  All marketing/travel/hardware related costs need to go in the project  or R&D, not operating
3.  Operating expenses will include SaaS Tools and hosting
4.  Total Expense - $1.5M

Existing headcount: $1,686,100
Incremental heads: $1,497,125
Marketing: $400,000
SaaS tools: $40,000
Hosting: $57,600
Other: $160,000
