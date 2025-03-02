import { HStack, Switch, useColorMode } from "@chakra-ui/react";
import React from "react";

function DarkSwitch() {
  let { colorMode, toggleColorMode } = useColorMode();
  return (
    <HStack>
      <Switch onChange={toggleColorMode}>DarkSwitch</Switch>
    </HStack>
  );
}
export default DarkSwitch;
