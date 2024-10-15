import { NodePlopAPI } from "node-plop"
import helpers from "handlebars-helpers"
import { crudGenerator } from "./generators"
import slugify from "slugify"
import { hyphenate } from "./utils"

export default function plop(plop: NodePlopAPI) {
  plop.setHelper("eq", helpers().eq)
  plop.setHelper("slugify", slugify)
  plop.setHelper("hyphenate", hyphenate)
  plop.setHelper("title", require("handlebars-helpers")(["string"]).titleize)
  plop.setGenerator("crud", crudGenerator)
}
