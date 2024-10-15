export enum CrudPromptNames {
  "goal" = "goal",
  "controllerType" = "controllerType",
  "entityName" = "entityName",
  "pluralName" = "pluralName",
  "entityId" = "entityId",
  "package" = "package"
}

export const GoalChoices = ["controller", "service", "dao", "repository"]
export const IdTypeChoices = ["Integer", "Long", "UUID"]

export type AnswersCrud = { [P in CrudPromptNames]: string }
