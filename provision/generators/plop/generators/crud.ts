import { Actions, PlopGeneratorConfig } from "node-plop"
import * as path from "path"
import { baseProjectPath, templatesPath } from "../utils"
import {
  AnswersCrud,
  CrudPromptNames,
  GoalChoices,
  IdTypeChoices
} from "./entities"

const helpers = require("handlebars-helpers")(["string"])

export const crudGenerator: PlopGeneratorConfig = {
  description: "Create a CRUD for a named entity",
  prompts: [
    {
      type: "list",
      name: CrudPromptNames.goal,
      message: "Select a goal",
      choices: GoalChoices
    },
    {
      type: "input",
      name: CrudPromptNames.entityName,
      message: "What is the entity's name?",
      default: "sample"
    },
    {
      type: "input",
      name: CrudPromptNames.pluralName,
      message: "What is the entity's plural name? (the db's table name)",
      default: (ans: AnswersCrud) => ans.entityName.concat("s")
    },
    {
      type: "list",
      name: CrudPromptNames.entityId,
      message: "What is the entity's id type?",
      choices: IdTypeChoices
    },
    {
      type: "input",
      name: CrudPromptNames.package,
      message: "Which is the base package for the future files?",
      default: "com.joalvarez"
    }
  ],
  actions: (data) => {
    const answers = data as AnswersCrud

    const projectRootPath = path.join(baseProjectPath, answers.package.replace(/\./g, "/"))

    const actions: Actions = []

    let goals: Map<string, string> = new Map()

    switch (answers.goal) {
      case "controller":
        goals.set("Controller", "controller")
      case "service":
        goals.set("Service", "service")
      case "dao":
        goals.set("DAO", "data/dao")
    }
    goals.set("Repository", "data/repository")
    goals.set("Mapper", "data/mapper")
    goals.set("", "data/domain")
    goals.set("DTO", "data/dto")

    goals.forEach((goalPath, goal) => {
      const titleizedName = helpers.titleize(answers.entityName).replace(" ", "")
      const className = titleizedName.concat(goal)
      actions.push({
        type: "add",
        templateFile: `${templatesPath}/${goal.length == 0 ? "Domain" : goal}.hbs`,
        path: path.join(projectRootPath, goalPath, className.concat(".java")),
        abortOnFail: false,
        data: {
          className: className,
          name: titleizedName
        }
      })
    })

    return actions
  }
}
