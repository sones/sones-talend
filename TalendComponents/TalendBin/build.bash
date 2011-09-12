export BIN_DIR=$PWD
cd ..
export WORKING_DIR=$PWD
export COMP_DIR=$WORKING_DIR/TalendCompDef
export HLP_DIR=$WORKING_DIR/TalendHelpers
export TMPL_DIR=$WORKING_DIR/TalendTemplates

# Clean
rm -Rf $BIN_DIR/Components

# Create the output directory
mkdir $BIN_DIR/Components

# Copy the component definitions 
cp -R $COMP_DIR/tSonesInput $BIN_DIR/Components
cp -R $COMP_DIR/tSonesOutput $BIN_DIR/Components

# Copy the helper library to the components
cp $HLP_DIR/jar/* $BIN_DIR/Components/tSonesInput
cp $HLP_DIR/jar/* $BIN_DIR/Components/tSonesOutput

# Copy the java client to the components
cp $TMPL_DIR/lib/* $BIN_DIR/Components/tSonesInput
cp $TMPL_DIR/lib/* $BIN_DIR/Components/tSonesOutput

# Copy the templates to the comonents
cp $TMPL_DIR/templates/tSonesInput* $BIN_DIR/Components/tSonesInput
cp $TMPL_DIR/templates/tSonesOutput* $BIN_DIR/Components/tSonesOutput

 
