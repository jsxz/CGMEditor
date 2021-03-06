/*
 * <copyright> Copyright 1997-2003 BBNT Solutions, LLC under sponsorship of the
 * Defense Advanced Research Projects Agency (DARPA).
 * Copyright 2009 Swiss AviationSoftware Ltd.
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the Cougaar Open Source License as published by DARPA on
 * the Cougaar Open Source Website (www.cougaar.org).
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package net.sf.jcgm.core;

import java.awt.geom.Point2D;
import java.io.*;



/**
 * Class=5, Element=16
 * @author xphc (Philippe Cadé)
 * @author BBNT Solutions
 * @version $Id: CharacterOrientation.java 46 2011-12-14 08:26:44Z phica $
 */
public class CharacterOrientation extends Command {
    private double xUp;
	private double yUp;
	private double xBase;
	private double yBase;

    public CharacterOrientation() {
        super(5, 16, 1);
    }

    public CharacterOrientation(double xUp, double yUp, double xBase,
            double yBase) {
        this();
        this.xUp = xUp;
        this.yUp = yUp;
        this.xBase = xBase;
        this.yBase = yBase;
    }

    public void write(int tagID, CGMOutputStream cgm) throws IOException {
        cgm.writeVDC(xUp);
        cgm.writeVDC(yUp);
        cgm.writeVDC(xBase);
        cgm.writeVDC(yBase);
    }
		
	public CharacterOrientation(int ec, int eid, int l, DataInput in)
            throws IOException {
        super(ec, eid, l, in);
        
        this.xUp = makeVdc();
        this.yUp = makeVdc();
        this.xBase = makeVdc();
        this.yBase = makeVdc();
        
        unimplemented("CharacterOrientation");
        
        // make sure all the arguments were read
        assert (this.currentArg == this.args.length);
    }

    @Override
	public void paint(CGMDisplay d) {
    	d.setCharacterOrientation(new Point2D.Double(this.xUp, this.yUp), new Point2D.Double(this.xBase, this.yBase));
	}

	@Override
	public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("CharacterOrientation");
    	sb.append(" xUp=").append(this.xUp);
    	sb.append(" yUp=").append(this.yUp);
    	sb.append(" xBase=").append(this.xBase);
    	sb.append(" yBase=").append(this.yBase);
        return sb.toString();
    }
}

/*
 * vim:encoding=utf8
 */
